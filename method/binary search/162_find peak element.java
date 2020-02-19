162. Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], 

find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

T:O(logN)

//如果大于，则说明峰值在前面，如果小于则在后面。这样就可以找到一个峰值了，代码如下：

class Solution {
    public int findPeakElement(int[] nums) {
        //求局部可用二分查找
        if(nums.length==1) return 0;
        int len=nums.length-1;//防止mid+1越界
        int left=0;
        int right=len;
        while(left<right){
            int mid =left+(right-left)/2;
            if(nums[mid]>nums[mid+1])
                right=mid;
            else 
                left=mid+1;
        }
        return right;
        
    }
}