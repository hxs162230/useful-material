322. Coin Change

You are given coins of different 

denominations and a total amount of money amount. 

Write a function to compute the fewest number of coins that you need to 

make up that amount. 

If that amount of money cannot be made up by any combination of the coins, 

return -1.

Example 1:



Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.

T:O(N)
S:O(N)

class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i] 多少個COINS組成 =>  i value;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1); 
        dp[0]=0;
        for(int coin:coins){
            for(int i=coin;i<amount+1;i++){
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return (dp[amount]>amount?-1:dp[amount]);
    }
}


class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] d:dp) Arrays.fill(d,amount+1);
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==amount+1?-1:dp[n][amount];
    }
}