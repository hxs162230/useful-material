417. Pacific Atlantic Water Flow

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 
这道题给了我们一个二维数组，说是数组的左边和上边是太平洋，右边和下边是大西洋，
假设水能从高处向低处流，问我们所有能流向两大洋的点的集合。刚开始博主没有理解题意，
以为加括号的点是一条路径，连通两大洋的，但是看来看去感觉也不太对，后来终于明白了，
是每一个点单独都有路径来通向两大洋。那么就是典型的搜索问题，
我最开始想的是对于每个点都来搜索是否能到达边缘，
只不过搜索的目标点不再是一个单点，而是所有的边缘点，
照这种思路写出的代码无法通过 OJ 大数据集，那么就要想办法来优化代码，
优化的方法跟之前那道 Surrounded Regions 很类似，都是换一个方向考虑问题，
既然从每个点向中间扩散会 TLE，那么我们就把所有边缘点当作起点开始遍历搜索，
然后标记能到达的点为 true，分别标记出 pacific 和 atlantic 能到达的点，
那么最终能返回的点就是二者均为 true 的点。我们可以先用DFS来遍历二维数组，参见代码如下：


class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length<=0 || matrix[0].length<=0) return new ArrayList<int[]>();
        List<int[]> lol = new ArrayList<>();
        boolean[][] p = new boolean[matrix.length][matrix[0].length];
        boolean[][] a = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dfs(matrix,0,i,0,p);
            dfs(matrix,matrix.length-1,i,0,a);
        }
        for(int i=0;i<matrix.length;i++){
            dfs(matrix,i,0,0,p);
            dfs(matrix,i,matrix[0].length-1,0,a);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(p[i][j] && a[i][j])
                    lol.add(new int[]{i,j});
            }
        }
        return lol;
    }
    public void dfs(int[][] matrix, int x,int y, int h, boolean[][] seen){
        if(x<0 ||y<0 ||x >=matrix.length ||y>=matrix[0].length) return;
        if(seen[x][y] || matrix[x][y]<h) return;
        seen[x][y]=true;
        dfs(matrix,x-1,y,matrix[x][y],seen);
        dfs(matrix,x+1,y,matrix[x][y],seen);
        dfs(matrix,x,y-1,matrix[x][y],seen);
        dfs(matrix,x,y+1,matrix[x][y],seen);
    }
}