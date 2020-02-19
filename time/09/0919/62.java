62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] p =new int[m][n];
     
        for(int i=0;i<m;i++){
            p[i][0]=1;
        }
        for(int j=0;j<n;j++){
            p[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                p[i][j]=p[i-1][j]+p[i][j-1];
            }
        }
        return p[m-1][n-1];
    }
}