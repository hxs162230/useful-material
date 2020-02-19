34. Find First and Last Position of Element in Sorted Array
Medium

2159

100

Favorite

Share
Given an array of integers nums sorted in ascending order, 

find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(right==0 && nums[0]==target) return new int[]{0,0};
        if(right<=left) return new int[]{-1,-1};
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else
                right=mid;
        }
      //  System.out.println(right);
        if(nums[right]!=target) return new int[]{-1,-1};
        else{
            int low=right;
        
        while(right<nums.length-1 && nums[right]==nums[right+1]) {
            right++;
        }
            int high=right;
       // System.out.println(high);
        
        int[] arr=new int[2];
        arr[0]=low;
        arr[1]=high;
        
        return arr;
    
        }    
    }
}