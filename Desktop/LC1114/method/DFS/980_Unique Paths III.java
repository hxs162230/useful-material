980. Unique Paths III

On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 

that "walk over" every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 


class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sx=-1;
        int sy=-1;
        int number=1; //把grid[i][j]==2算上(加上grid[][]==0為總共跳數)   初始化為1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
                else if(grid[i][j]==0)
                    number++;
            }
        }
        return dfs(grid,sx,sy,number);
        
    }
    public int dfs(int[][] g,int i,int j,int n){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]==-1) 
            return 0;
        if(g[i][j]==2&&n==0) return 1;
        if(g[i][j]==2&&n!=0) return 0;
        g[i][j] =-1;
        int ans = dfs(g,i-1,j,n-1)+dfs(g,i+1,j,n-1)+dfs(g,i,j-1,n-1)+dfs(g,i,j+1,n-1);
        g[i][j] =0;
        return ans;
    }
}