1162. As Far from Land as Possible
Medium

767

33

Add to List

Share
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int cntOfZero = 0;
        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    cntOfZero++;
                    if(nbhaveOne(grid,i,j)){
                        q.add(new int[]{i,j,1});
                        dist[i][j] = 1;
                    }
                }
            }
        }
        //int cntOdOne = m*n-cntOfZero;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] cur = q.poll();
                max = Math.max(max,cur[2]);
                for(int[] dir:dirs){
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if(x<0||y<0||x>=m||y>=n||grid[x][y]==1) continue;
                    if(dist[x][y]>cur[2]+1){
                        dist[x][y] = cur[2]+1;
                        q.add(new int[]{x,y,cur[2]+1});
                    }
                }
            }
        }
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(dist[i][j]+" ");
//             }
//             System.out.println();
//         }
        
        return (cntOfZero==0||cntOfZero==m*n)? -1: max;
    }
    public boolean nbhaveOne(int[][] grid,int i,int j){
        if(i+1<grid.length && grid[i+1][j]==1) return true;
        if(i-1>=0 && grid[i-1][j]==1) return true;
        if(j+1<grid[0].length && grid[i][j+1]==1) return true;
        if(j-1>=0 && grid[i][j-1]==1) return true;
        return false;
    }
}