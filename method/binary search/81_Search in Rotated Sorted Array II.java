81. Search in Rotated Sorted Array II

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

而如果可以有重复值，就会出现来面两种情况，[3 1 1] 和 [1 1 3 1]，对于这两种情况中间值等于最右值时，
目标值3既可以在左边又可以在右边，那怎么办么，对于这种情况其实处理非常简单，只要把最右值向左一位即可继续循环，
如果还相同则继续移，直到移到不同值为止，然后其他部分还采用 
Search in Rotated Sorted Array 中的方法，可以得到代码如下：


class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]>nums[left]){
                if(nums[mid]>target && nums[left]<=target)
                right=mid-1;
                else
                left=mid+1;
            }
            else if(nums[mid]<nums[left]){
                if(nums[mid]<target && nums[right]>=target)
                left=mid+1;
                else
                right=mid-1;
            }
            else
                left++;
        }
        return false;
    }
}


class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<nums[right]){
                if(target<=nums[right] && target>nums[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else if(nums[mid]>nums[right]){
                if(target<nums[mid] && target>=nums[left])
                    right = mid-1;
                else 
                    left = mid+1;
            }
            else 
                right--;
            
        }
        return false;
    }
}