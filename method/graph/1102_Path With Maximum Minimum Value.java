1102. Path With Maximum Minimum Value
Medium

178

19

Favorite

Share
Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].

The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).

 

Example 1:



Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow. 
Example 2:



Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2
Example 3:



Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3
 

Note:

1 <= R, C <= 100
0 <= A[i][j] <= 10^9

T:O(MNlogMN)
S:O(MN)

class Solution {
    public int maximumMinimumPath(int[][] A) {
        if(A.length==0||A[0].length==0) return -1;
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new cmp());
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        pq.add(new int[]{A[0][0],0});
        int minInpath = A[0][0];
        A[0][0]=-1;
        while(!pq.isEmpty()){
                int[] t = pq.poll();
                int val =t[0];
                int ox = t[1]/n;
                int oy = t[1]%n;
                minInpath = Math.min(minInpath,val);
                if(ox==m-1&&oy==n-1) return minInpath;
                for(int[] dir:dirs){
                    int nx = ox+dir[0];
                    int ny = oy+dir[1];
                    if(nx<0||ny<0||nx>=m||ny>=n||A[nx][ny]==-1) continue;
                    pq.add(new int[]{A[nx][ny],nx*n+ny});
                    A[nx][ny]=-1;
                }
        }
        return -1;
    }
}
class cmp  implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return b[0]-a[0];
    }
}