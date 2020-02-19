741. Cherry Pickup
Hard

586

44

Favorite

Share
In a N x N grid representing a field of cherries, each cell is one of three possible integers.

 

0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.
 

Your task is to collect maximum number of cherries possible by following the rules below:

 

Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 

 

Example 1:

Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
Explanation: 
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
 

Note:

grid is an N by N 2D array, with 1 <= N <= 50.
Each grid[i][j] is an integer in the set {-1, 0, 1}.
It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.
 
1 1 1 1 0 0 0
0 0 0 1 0 0 0
0 0 0 1 0 0 1
1 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 1 1 1 1    corner case
Actually we can collect all cherries

class Solution {
    int[][] grid;
    int[][][] cache;
    public int cherryPickup(int[][] grid) {
        this.grid=grid;
        int n = grid.length;
        cache = new int[n][n][n];
        for(int[][] arr1:cache)
            for(int[] arr2:arr1)
                Arrays.fill(arr2,Integer.MIN_VALUE);
        return Math.max(0,dfs(n-1,n-1,n-1));
    }
    public int dfs(int x1,int y1,int x2){
        int y2 = x1+y1-x2;
        if(x1<0||x2<0||y1<0||y2<0) return -1;
        if(grid[x1][y1]==-1||grid[x2][y2]==-1) return -1;
        if(cache[x1][y1][x2]!=Integer.MIN_VALUE) return cache[x1][y1][x2];   再訪則return 避免revisit
        if(x1==0&&y1==0) return cache[x1][y1][x2] = grid[x1][y1];
        int ans = Math.max(Math.max(dfs(x1-1,y1,x2),dfs(x1-1,y1,x2-1)),Math.max(dfs(x1,y1-1,x2),dfs(x1,y1-1,x2-1)));
        if(ans==-1) return cache[x1][y1][x2]=-1;
            ans+=grid[x1][y1];
        if(x1!=x2)
            ans+=grid[x2][y2];
        return cache[x1][y1][x2]=ans;
            
    }
}