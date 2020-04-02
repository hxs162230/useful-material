1049. Last Stone Weight II
Medium

398

19

Add to List

Share
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 100

2D

class Solution {
    public int lastStoneWeightII(int[] stones) {
        //diff = s1-s2;
        //sum =  s1+s2;
        //diff = sum -2s2;
        //smallest diff => largest s2;
        int sum = 0;
        int n = stones.length;
        for(int i:stones) sum+=i;
        int[][] dp = new int[n+1][sum/2+1];
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum/2;j++){
                if(j>=stones[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return sum-2*dp[n][sum/2];
    }
}

1D 

class Solution {
    public int lastStoneWeightII(int[] stones) {
        //diff = s1-s2;
        //sum =  s1+s2;
        //diff = sum -2s2;
        //smallest diff => largest s2;
        int sum = 0;
        int n = stones.length;
        for(int i:stones) sum+=i;
        int[] dp = new int[sum/2+1];
        
        for(int i=1;i<=n;i++){
            for(int j=sum/2;j>=stones[i-1];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i-1]]+stones[i-1]); 
            }    
        }
        
        return sum-2*dp[sum/2];
    }
}