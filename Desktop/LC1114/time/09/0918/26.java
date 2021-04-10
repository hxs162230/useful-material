26. Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

T:O(N)
S:O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j-1]){
                nums[j] = nums[i];   
                j++;
            }   
        }
        return j; 
    }
}