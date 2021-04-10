class Solution {
    /*
    dp[i][j] 代表在以i, j这一格为右下角的正方形边长。
    如果这一格的值也是1，那这个正方形的边长就是他的上面，
    左手边，和斜上的值的最小边长 +1。因为如果有一边短了缺了，都构成不了正方形。
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length<=0 ||matrix[0].length<=0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=matrix[i][j]-'0';
                }
                else if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;              
                }
                  res = Math.max(res,dp[i][j]);  
            }
        }
        return res*res;
    }
}