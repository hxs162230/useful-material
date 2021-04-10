You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount. 
You may assume that you have infinite number of each kind of coin.


class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1; 
        if(coins.length==0) return 0;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int j=coin;j<amount+1;j++){
                dp[j]=dp[j]+dp[j-coin];
                //不加上硬幣的組合+加上硬幣的組合
            }
        }
        return dp[amount];
    }
}