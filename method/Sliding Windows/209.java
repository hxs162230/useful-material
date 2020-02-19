209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int size = nums.length+1;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=s&&left<=right){
                size = Math.min(size,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return size==nums.length+1?0:size;
    }
}