280. Wiggle Sort

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
//不能連續兩個值上升或下降   屬於GREEDY
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null) return ;
        for(int i=1;i<nums.length;i++){
            if((i)%2==0&&nums[i]>nums[i-1])
                swap(nums,i);
            if((i)%2==1&&nums[i]<nums[i-1])
                swap(nums,i);
        }
    }
    public void swap(int[] nums,int i){
        int tmp = nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=tmp;
    }
}