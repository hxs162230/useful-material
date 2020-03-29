329. Longest Increasing Path in a Matrix
Hard

1286

22

Favorite

Share
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

T:O(MN*4^MN)

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int globalmax=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                globalmax = Math.max(globalmax,dfs(matrix,dp,i,j,Integer.MIN_VALUE));
            }
        }
        return globalmax;
    }
    public int dfs(int[][] m,int[][] dp,int i,int j,int pre){
        if(i<0||j<0||i>=dp.length||j>=dp[0].length||pre>=m[i][j]) return 0;
        if(dp[i][j]>0) return dp[i][j];
        int tmp=0;
        int curVal = m[i][j];
        tmp = Math.max(tmp,1+dfs(m,dp,i-1,j,curVal));
        tmp = Math.max(tmp,1+dfs(m,dp,i+1,j,curVal));
        tmp = Math.max(tmp,1+dfs(m,dp,i,j-1,curVal));
        tmp = Math.max(tmp,1+dfs(m,dp,i,j+1,curVal));

        dp[i][j] = tmp;
        return dp[i][j];
    }
}