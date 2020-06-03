548. Split Array with Equal Sum
Medium

200

66

Add to List

Share
Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5. 
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].

class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        //if(n<=6) return false;
        int[] presum = new int[n+1];
        for(int i=1;i<=n;i++){
            presum[i] = presum[i-1]+nums[i-1];
        }        
        for(int j=3;j<n-3;j++){
            HashSet<Integer> set = new HashSet<>();
            for(int i=1;i<=j-2;i++){
                if(presum[j]-presum[i+1]==presum[i]) set.add(presum[i]);
            }
            for(int k=j+2;k<n-1;k++){
                int lastsum = presum[n]-presum[k+1];
                int secondlast = presum[k]-presum[j+1];

                if(secondlast==lastsum&&set.contains(lastsum))
                    return true;
            }
        }
        return false;
    }
}