1254. Number of Closed Islands
Medium

393

17

Add to List

Share
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==n-1){
                    if(grid[i][j]==0)
                        floodDfs(i,j,grid);
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    floodDfs(i,j,grid);
                    num++;
                }
            }
        }
        return num;
    }
    public void floodDfs(int i,int j,int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return ;
        if(grid[i][j]==1||grid[i][j]==2) return ;
        grid[i][j] = 2;
        floodDfs(i-1,j,grid);
        floodDfs(i+1,j,grid);
        floodDfs(i,j-1,grid);
        floodDfs(i,j+1,grid);
    }
}