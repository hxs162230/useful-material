308. Range Sum Query 2D - Mutable
Hard

364

50

Add to List

Share
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.


class NumMatrix {
    int[][] matrix;
    Fenwick tree;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return ;
        this.matrix = matrix;
        this.tree = new Fenwick(matrix.length,matrix[0].length);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                tree.update(i+1,j+1,matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int delta = val-matrix[row][col];
        tree.update(row+1,col+1,delta);
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return tree.find(row2+1,col2+1)-tree.find(row2+1,col1)
            -tree.find(row1,col2+1)+tree.find(row1,col1);
    }
}
class Fenwick{
    private int[][] fenwick;
    private int m;
    private int n;
    public Fenwick(int m,int n){
        this.fenwick = new int[m+1][n+1];
        this.m = m;
        this.n = n;
    }
    public void update(int i,int j,int delta){
        for(int a=i;a<=m;a+=lowbit(a)){
            for(int b=j;b<=n;b+=lowbit(b)){
                fenwick[a][b]+=delta;
            }
        }
    }
    public int find(int i,int j){
        int sum = 0;
        for(int a=i;a>0;a-=lowbit(a)){
            for(int b=j;b>0;b-=lowbit(b)){
                sum+=fenwick[a][b];
            }
        }
        return sum;
    }
    public int lowbit(int i){
        return i&(-i);
    }
}
