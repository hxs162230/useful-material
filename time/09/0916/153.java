153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

T:O(logN)

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        if(nums[left]>nums[right]){
        while(left<right){
        int mid = left+(right-left)/2;
        if(nums[mid]<nums[right])//right shift
            right=mid;
        else//left shift
            left=mid+1;
        }
        return nums[right];
    }
    else
        return nums[0];
    }
    
}