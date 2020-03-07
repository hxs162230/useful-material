188. Best Time to Buy and Sell Stock IV


Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

T:O(len*k)
S:O(k)
each day 可分買或不買  賣或不賣

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len<=1) return 0;
        if(k>=len/2){
            int sum=0;
            for(int i=1;i<len;i++){
                if(prices[i]>prices[i-1])
                    sum+=prices[i]-prices[i-1];
            }
            return sum;
        }
      int[] buy=new int[k+1];   maximum profit from at most k transactions
      int[] sell=new int[k+1];
      Arrays.fill(buy,Integer.MIN_VALUE);
      for(int i=0;i<len;i++){  
        for(int j=1;j<=k;j++){
          buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
          sell[j]=Math.max(sell[j],buy[j]+prices[i]);
          }
      }
        return sell[k];
    }
}