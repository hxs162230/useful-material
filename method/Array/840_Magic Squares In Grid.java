840. Magic Squares In Grid
Easy

104

958

Add to List

Share
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

 

Example 1:

Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int ans =0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                ans+=inside(i,j,grid);
            }
        }
        return ans;
    }
    private int inside(int i,int j,int[][] g){
        if(g[i][j]%2!=0) return 0;
        int[] col = new int[3];
        int[] row = new int[3];
        int dig = 0;
        int indig=0;
        int sum = 15;
        for(int x=i;x<i+3;x++){
            for(int y=j;y<j+3;y++){
                int n = g[x][y];
                if(n<0||n>9) return 0;
                row[x-i]+=n;
                col[y-j]+=n;
                if((x-i)==(y-j)) dig+=n;
                if((x-i+y-j)==2) indig+=n;
            }
        }
        int R=0;
        int C=0;
        int D=0;
        if(row[0]==15&&row[1]==15&&row[2]==15) R=1;
        if(col[0]==15&&col[1]==15&&col[2]==15) C=1;
        if(dig==15&&indig==15) D=1;
        return R==1&&C==1&&D==1?1:0;
        
    }
}