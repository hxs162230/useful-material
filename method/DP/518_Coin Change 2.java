518. Coin Change 2
Medium

1251

48

Add to List
 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer


You are given coins of different denominations and a 
total amount of money.
Write a function to compute the number of combinations 
that make up that amount. 
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