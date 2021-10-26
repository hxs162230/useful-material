934. Shortest Bridge
Medium

771

63

Add to List

Share
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: A = [[0,1],[1,0]]
Output: 1
Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

2 <= A.length == A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1



class Solution {
    HashSet<Integer> setA = new HashSet<>();
    HashSet<Integer> setB = new HashSet<>();
    HashSet<Integer> seen = new HashSet<>();
    public int shortestBridge(int[][] A) {
        int color = 2;
        int m = A.length;
        if(m==0) return 0;
        int n = A[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]==1){
                    dfs(i,j,A,color);
                    color++;
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(A[i][j]);
        //     }
        //     System.out.println();
        // }
        
        int step = 0;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!setA.isEmpty()&&!setB.isEmpty()){
            HashSet<Integer> tmp = new HashSet<>();
            if(setA.size()>setB.size()){
                tmp = setB;
                setB = setA;
                setA = tmp;
            }
            HashSet<Integer> next = new HashSet<>();
            for(int index : setA){
                int curx = index/n;
                int cury = index%n;
                for(int[] dir:dirs){
                    int nx = curx+dir[0];
                    int ny = cury+dir[1];
                    if(nx<0||ny<0||nx>=m||ny>=n) continue;
                    if(setB.contains(nx*n+ny)) return step;
                    if(seen.contains(nx*n+ny)) continue;
                    seen.add(nx*n+ny);
                    next.add(nx*n+ny);
                }
            }
            step++;
            setA = next;
        }
        
        return 0;
    }
    public void dfs(int i,int j,int[][] A,int color){
        if(i<0||i>=A.length||j<0||j>=A[0].length) return ;
        if(A[i][j]==0||A[i][j]==color) return ;
        
        A[i][j]=color;
        
        if(A[i][j]==2){
            setA.add(i*A[0].length+j);
        }
        else{
            setB.add(i*A[0].length+j);
        }
        seen.add(i*A[0].length+j);
        dfs(i+1,j,A,color);
        dfs(i-1,j,A,color);
        dfs(i,j-1,A,color);
        dfs(i,j+1,A,color);
    }
}