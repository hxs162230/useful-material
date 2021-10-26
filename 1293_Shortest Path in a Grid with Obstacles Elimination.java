1293. Shortest Path in a Grid with Obstacles Elimination
Hard

641

12

Add to List

Share
Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:

Input: 
grid = 
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]], 
k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10. 
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 

Example 2:

Input: 
grid = 
[[0,1,1],
 [1,1,1],
 [1,0,0]], 
k = 1
Output: -1
Explanation: 
We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

grid.length == m
grid[0].length == n
1 <= m, n <= 40
1 <= k <= m*n
grid[i][j] == 0 or 1
grid[0][0] == grid[m-1][n-1] == 0



class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        HashSet<String> seen = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k});
        seen.add("0,0,k");
        int dist = 0;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] cur = q.poll();
                int ammo = cur[2];
                if(cur[0]==m-1&&cur[1]==n-1) return dist;
                for(int[] dir :dirs){
                    int nx = cur[0]+dir[0];
                    int ny = cur[1]+dir[1];
                    String str = new StringBuilder(String.valueOf(nx)).append(",").append(String.valueOf(ny)).append(",").append(String.valueOf(ammo)).toString();
                    if(nx<0||ny<0||nx>=m||ny>=n) continue;
                    if(seen.contains(str)) continue;
                    if(grid[nx][ny]==1&&ammo>0){
                        q.add(new int[]{nx,ny,ammo-1});
                        seen.add(str);
                    }
                    else if(grid[nx][ny]==0){
                        q.add(new int[]{nx,ny,ammo});
                        seen.add(str);
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}