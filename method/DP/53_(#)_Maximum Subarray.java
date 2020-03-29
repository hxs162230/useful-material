53. Maximum Subarray
Easy

5342

216

Favorite

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, 

try coding another solution using the divide and conquer approach, which is more subtle.


T:O(N)
S:O(1)
如果curSum<0 則代表加入(上一個數)後變為負值
此時我們拋棄curSum 設其值為 nums[i](現在數)

class Solution {
    public int maxSubArray(int[] nums) {
        // if(nums.length==0) return 0;
        // if(nums.length==1) return nums[0];  
        int curSum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(curSum<0){
                curSum=nums[i];
            }
            else{
                curSum+=nums[i];
            }
            max=Math.max(curSum,max);
        }
        return max;
    }
}

nlogn  
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return divide(nums,0,nums.length-1);
    }
    public int divide(int[] nums,int left,int right){
        if(left>=right) return nums[left];
        int mid = (left)+(right-left)/2;
        int lm = divide(nums,left,mid);
        int rm = divide(nums,mid+1,right);
        int msum = nums[mid];
        int t = msum;
        
        for(int i=mid-1;i>=left;i--){
            t+=nums[i];
            msum = Math.max(msum,t);
        }
        t = msum;
        for(int i=mid+1;i<=right;i++){
            t+=nums[i];
            msum = Math.max(msum,t);
        }
        return Math.max(Math.max(lm,rm),msum);
    }

}