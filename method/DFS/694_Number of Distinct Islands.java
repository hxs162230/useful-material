694. Number of Distinct Islands

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 

(representing land) connected 4-directionally (horizontal or vertical.) 

You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.

这道题让我们求不同岛屿的个数，是之前那道 Number of Islands 的拓展，难点是如何去判断两个岛屿是否是不同的岛屿，
首先1的个数肯定是要相同，但是1的个数相同不能保证一定是相同的岛屿，比如例子2中的那两个岛屿的就不相同，
就是说两个相同的岛屿通过平移可以完全重合，但是不能旋转。如何来判断呢，可以发现可以通过相对位置坐标来判断，
比如使用岛屿的最左上角的1当作基点，那么基点左边的点就是 (0,-1)，右边的点就是 (0,1), 上边的点就是 (-1,0)，下面的点就是 (1,0)。
则例子1中的两个岛屿都可以表示为 [(0,0), (0,1), (1,0), (1,1)]，点的顺序是基点-右边点-下边点-右下点。通过这样就可以判断两个岛屿是否相同了，
下面这种解法没有用数组来存，而是 encode 成了字符串，比如这四个点的数组就存为 "0_0_0_1_1_0_1_1_"，
然后把字符串存入集合 unordered_set 中，利用其自动去重复的特性，就可以得到不同的岛屿的数量啦，参见代码如下：


class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        Set<String> numOfmap = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(i,j,grid,sb);
                    numOfmap.add(sb.toString());
                }
            }
        }
        return numOfmap.size();
    }
    public void dfs(int i,int j,int[][] grid,StringBuilder sb){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1)
            return;
        grid[i][j]=-1;
        sb.append("N");
        dfs(i+1,j,grid,sb);
        sb.append("S");
        dfs(i-1,j,grid,sb);
        sb.append("E");
        dfs(i,j+1,grid,sb);
        sb.append("W");
        dfs(i,j-1,grid,sb);
        sb.append("B");
   }
}