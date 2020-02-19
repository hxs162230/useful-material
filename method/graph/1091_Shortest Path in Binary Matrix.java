1091. Shortest Path in Binary Matrix
Medium

165

28

Favorite

Share
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0||grid[0].length==0||grid[0][0]==1) return -1;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        int[][] dist = new int[m][n];
        for(int[] d:dist) Arrays.fill(d,Integer.MAX_VALUE);
        dist[0][0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int cur = q.poll();
                int ox = cur/n;
                int oy = cur%n;
                int distance = dist[ox][oy];
                for(int[] dir:dirs){
                    int nx = ox+dir[0];
                    int ny = oy+dir[1];
                    if(nx<0||ny<0||nx>=m||ny>=n||grid[nx][ny]!=0) continue;
                    if(distance+1<dist[nx][ny]){
                        dist[nx][ny] = distance+1;
                        q.add(nx*n+ny);
                    }
                }
            }
        }
        return dist[m-1][n-1]==Integer.MAX_VALUE?-1:dist[m-1][n-1]+1;
    }
}