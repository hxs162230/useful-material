300. Longest Increasing Subsequence
Medium

3177

73

Favorite

Share
Given an unsorted array of integers, find the length of longest 

increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, 
it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?


dp[i] 表示以 nums[i] 为结尾的最长递增子串的长度
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}


nlogn run time
插入法 : 二分查找 DP數組存的並不是真的LIS數組，但利用性質相似的點長度一樣
DP數組存的為一個遞增序列，插入值在DP.SIZE()內則對其內容修改


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        List<Integer> dp = new ArrayList<>();
        for(int num:nums){
            int left=0;
            int right=dp.size();
            while(left<right){
                int mid = left+(right-left)/2;
                if(dp.get(mid)<num) left = mid+1;
                else right = mid;
            }
            if(right>=dp.size()) dp.add(num);
            else dp.set(right,num);
        }
        
        return dp.size();
        
    }
}