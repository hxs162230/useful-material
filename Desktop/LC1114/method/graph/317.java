317. Shortest Distance from All Buildings
Hard

567

32

Favorite

Share
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

// 这道题给我们了一些建筑物的坐标和一些障碍物的坐标，让我们找一个位置，
// 使其到所有建筑物的曼哈顿距离之和最小，起初我觉得这题应该算Best Meeting Point那道题的拓展，
// 不同之处在于这道题有了障碍物的存在，这样就使得直接使用曼哈顿距离的计算公式变得不可行，
// 因为在有些情况下，障碍物完全封死了某个建筑物，那么这时候应该返回-1。所以这道题只能使用遍历迷宫的思想来解，
// 那么这题就和之前那道Walls and Gates很类似，但是这道题用DFS就会很麻烦，
// 因为我们的目标是要建立Distance Map，所以BFS的特性使得其非常适合建立距离场，
// 而DFS由于是沿着一个方向一股脑的搜索，然后会面临着更新距离的问题，只有当递归函数都调用结束后，距离场才建立好，那么我们累加距离场时又得整个遍历一遍，
// 非常不高效。主要原因还是由于DFS的搜索方式不适合距离场，
// 因为BFS遍历完一个点后，不会再来更改这个点的值，而DFS会反复的更改同一个点的值，
// 我强行用DFS写出的方法无法通过OJ最后一个大集合，所以这道题还是老老实实地用BFS来解题吧，
// 还是需要借助queue来遍历，我们对于每一个建筑的位置都进行一次全图的BFS遍历，每次都建立一个dist的距离场，
// 由于我们BFS遍历需要标记应经访问过的位置，而我们并不想建立一个visit的二维矩阵，那么怎么办呢，
// 这里用一个小trick，我们第一遍历的时候，都是找0的位置，遍历完后，我们将其赋为-1，
// 这样下一轮遍历我们就找-1的位置，然后将其都赋为-2，以此类推直至遍历完所有的建筑物，
// 然后在遍历的过程中更新dist和sum的值，注意我们的dist算是个局部变量，每次都初始化为grid，
// 真正的距离场累加在sum中，由于建筑的位置在grid中是1，所以dist中初始化也是1，
// 累加到sum中就需要减1，我们用sum中的值来更新结果res的值，最后根据res的值看是否要返回-1，参见代码如下：
class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] cntOfbuilding = new int[m][n];
        int[][] dir = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        Queue<int[]> q = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        int building = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    building++;
                    boolean[][] seen = new boolean[m][n];
                    q.add(new int[]{i,j});
                    int level = 1;
                    while(!q.isEmpty()){
                        for(int iSize=q.size()-1;iSize>=0;iSize--){
                            int[] o_idx = q.peek();
                            q.poll();
                            for(int[] dr:dir){
                                int ni = dr[0]+o_idx[0];
                                int nj = dr[1]+o_idx[1];
                                if(ni>=0&&ni<m&&nj>=0&&nj<n&&grid[ni][nj]==0&&!seen[ni][nj]){
                                    dist[ni][nj]+=level;
                                    ++cntOfbuilding[ni][nj];
                                    seen[ni][nj]=true;
                                    q.add(new int[]{ni,nj});
                                }
                            }
                        }
                        level++;
                        
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&cntOfbuilding[i][j]==building)
                    res = Math.min(res,dist[i][j]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}