368. Largest Divisible Subset
Medium

1717

87

Add to List

Share
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        Arrays.sort(nums);
        int max = 0;
        int idx = -1;
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j=i-1;j>=1;j--){
                if(nums[i-1]%nums[j-1]==0)
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        pre[i] = j;
                    }
            }
            if(dp[i]>max){
                max = dp[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(idx!=-1){
            res.add(nums[idx-1]);
            idx = pre[idx];
        }
        
        return res;
    }
}