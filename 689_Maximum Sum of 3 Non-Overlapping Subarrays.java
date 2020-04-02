689. Maximum Sum of 3 Non-Overlapping Subarrays
Hard

787

43

Add to List

Share
In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:

Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 

Note:

nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).


class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //  [0,i-1]    [i,i+k-1]    [i+k,n-1]
        // i-1-0+1>=k =>       i>=k
        // n-1-(i+k)+1>=k =>   i<=n-2k
        // derive     k<=i<=n-2k
        
        
        int n = nums.length;
        int[] sum = new int[n+1];
        int[] L = new int[n];
        int[] R = new int[n];
        int[] res = new int[3];
        for(int i =1;i<=n;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        int leftMax = sum[k]-sum[0];
        L[k-1] = 0;
        for(int i=k;i<n;i++){
           if(sum[i+1]-sum[i-k+1]>leftMax){
               leftMax = sum[i+1]-sum[i-k+1];
               L[i] = i-k+1;
           }   
           else{
               L[i] = L[i-1];
           }
        }
        int rightMax = sum[n] - sum[n-k];
        R[n-k] = n-k;
        for(int i=n-k-1;i>=0;i--){
            if(sum[i+k]-sum[i]>=rightMax){
                rightMax = sum[i+k]-sum[i];
                R[i] = i;
            }
            else{
                R[i] = R[i+1];
            }
        }
        int tot = 0;
        for(int i=k;i<=n-2*k;i++){
            int l = L[i-1];
            int r = R[i+k];
            int t = (sum[i+k]-sum[i])+sum[l+k]-sum[l]+sum[r+k]-sum[r];
            if(t>tot){
                tot = t;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}