665. Non-decreasing Array
Medium

2493

596

Add to List

Share
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105


class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int idx = -1;
        for(int i=1;i<len;i++){
            if(nums[i-1]>nums[i]){
                cnt++;
                idx = i;
                if(cnt>1) return false;
            }
        }
        //non dec 
        if(cnt==0) return true;
        
        if(cnt == 1){
            //end points (happened in first (idx=1) or last)
            if(idx==1||idx==len-1) return true;
            //middle way (2 cases)
            //  (i-2) / (i-1) \ (i)
            if(nums[idx]>=nums[idx-2]) return true;            
            //  (i-1) \ (i) / (i+1)
            if(nums[idx+1]>=nums[idx-1]) return true;
        }


	65. Non-decreasing Array









Medium

2493

596

Add to List

Share
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105


class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int idx = -1;
        for(int i=1;i<len;i++){
            if(nums[i-1]>nums[i]){
                cnt++;
                idx = i;
                if(cnt>1) return false;
            }
        }
        //non dec 
        if(cnt==0) return true;
        
        if(cnt == 1){
            //end points (happened in first (idx=1) or last)
            if(idx==1||idx==len-1) return true;
            //middle way (2 cases)
            //  (i-2) / (i-1) \ (i)
            if(nums[idx]>=nums[idx-2]) return true;            
            //  (i-1) \ (i) / (i+1)
            if(nums[idx+1]>=nums[idx-1]) return true;
        }
        
        return false;
    }
}
        
        return false;
    }
}
