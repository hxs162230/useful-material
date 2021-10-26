827. Making A Large Island
Hard

596

18

Add to List

Share
In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Notes:

1 <= grid.length = grid[0].length <= 50.
0 <= grid[i][j] <= 1.


class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int zeros = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                   grid[i][j] = 1;
                   max = Math.max(max,dfs(i,j,grid,new boolean[m][n])); 
                   grid[i][j] = 0; 
                   zeros++; 
                }
            }
        }

        
        return zeros==0?m*n:max;
    }

    public int dfs(int i,int j,int[][] g,boolean[][] seen){
        if(i<0||j<0||i>=g.length||j>=g[0].length) return 0;
        if(seen[i][j]||g[i][j]==0) return 0;
        seen[i][j] = true;
        return 1+dfs(i+1,j,g,seen)+dfs(i-1,j,g,seen)+dfs(i,j+1,g,seen)+dfs(i,j-1,g,seen);
        
    }
}