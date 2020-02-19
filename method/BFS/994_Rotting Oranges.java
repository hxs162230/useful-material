994. Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  

If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int cntfresh=0;
        int minutes=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }
                else if(grid[r][c]==1)
                    cntfresh++;
            }
        }
        if(cntfresh==0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] pos = q.poll();
                for(int[] dir:dirs){
                    int nx = pos[0]+dir[0];
                    int ny = pos[1]+dir[1];
                    if(nx<0||nx>=m||ny<0||ny>=n||grid[nx][ny]==0||grid[nx][ny]==2) continue;
                    cntfresh--;
                    grid[nx][ny]=2;
                    q.add(new int[]{nx,ny});
                }
            }
            minutes++;
        }
        return cntfresh!=0?-1:minutes-1;
    }
}