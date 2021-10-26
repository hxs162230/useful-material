542. 01 Matrix
Medium

1803

114

Add to List

Share
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.



time O(MN+V)
space V
class Solution {
    boolean[][] seen;
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m<=0) return matrix;
        int n = matrix[0].length;
        if(n<=0) return matrix;
        seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]!=0&&hasZeroNb(i,j,m,n,matrix)){
                    q.add(new int[]{i,j});
                    seen[i][j] = true;
                    //System.out.println(i+","+j);
                }
            }
        }
        bfs(q,matrix,m,n);
        return matrix;
    }
    public void bfs(Queue<int[]> q,int[][] matrix,int m,int n){
        int step = 1;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            for(int s=q.size();s>0;s--){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                //System.out.println(cx+","+cy);
                matrix[cx][cy] = step;
                for(int[] dir:dirs){
                    int nx = cx+dir[0];
                    int ny = cy+dir[1];
                    if(nx<0||ny<0||nx>=m||ny>=n) continue;
                    if(matrix[nx][ny]==0) continue;
                    if(seen[nx][ny]) continue;
                    q.add(new int[]{nx,ny});
                    seen[nx][ny] = true;
                }
            }
            step++;
        }
    }
    public boolean hasZeroNb(int i,int j,int m,int n,int[][] matrix){
        if(i+1<m&&matrix[i+1][j]==0) return true;
        if(j+1<n&&matrix[i][j+1]==0) return true;
        if(i-1>=0&&matrix[i-1][j]==0) return true;
        if(j-1>=0&&matrix[i][j-1]==0) return true;
        
        return false;
    }
}