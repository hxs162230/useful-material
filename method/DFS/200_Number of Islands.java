200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

T:O(MN)
S:O(MN)

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,char[][] g){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]!='1') return ;
        g[i][j] = '#';
        dfs(i+1,j,g);
        dfs(i-1,j,g);
        dfs(i,j+1,g);
        dfs(i,j-1,g);
    }
}