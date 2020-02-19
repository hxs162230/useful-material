974. Subarray Sums Divisible by K
Medium

464

41

Favorite

Share
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

 

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 

Note:

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] dp  = new int[K];
        int sum=0;
        int cnt=0;
        dp[0]=1;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            int mod = (sum%K+K)%K;
            cnt+=dp[mod];
            dp[mod]++;
        }
        return cnt;
    }
}

//https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/310767/(Python)-Concise-Explanation-and-Proof