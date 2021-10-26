646. Maximum Length of Pair Chain
Medium

1237

87

Add to List

Share
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].


class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n = pairs.length;
        int[] dp = new int[n+1];
        int res = 0;
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(pairs[i-1][0]>pairs[j-1][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}