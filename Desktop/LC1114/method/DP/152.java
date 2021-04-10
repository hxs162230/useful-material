152. Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


T:O(N)
S:O(1)
greedy DP
和 nums[i]相比 取 curmax 和 curmin

下面这种方法也是用两个变量来表示当前最大值和最小值的，但是没有无脑比较三个数，而是对于当前的nums[i]值进行了正负情况的讨论：

1. 当遍历到一个正数时，此时的最大值等于之前的最大值乘以这个正数和当前正数中的较大值，此时的最小值等于之前的最小值乘以这个正数和当前正数中的较小值。
2. 当遍历到一个负数时，我们先用一个变量t保存之前的最大值mx，然后此时的最大值等于之前最小值乘以这个负数和当前负数中的较大值，此时的最小值等于之前保存的最大值t乘以这个负数和当前负数中的较小值。

3. 在每遍历完一个数时，都要更新最终的最大值。

P.S. 如果这里改成求最小值的话，就是求最小子数组乘积，并且时间复杂度是醉人的O(n)，是不是很强大呢，参见代码如下：

class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        
        int curMAX=nums[0];
        int curMIN=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
            curMAX=Math.max(nums[i],curMAX*nums[i]);
            curMIN=Math.min(nums[i],curMIN*nums[i]);
            }
            else {
                int t=curMAX;
                curMAX=Math.max(nums[i],curMIN*nums[i]);
                curMIN=Math.min(nums[i],t*nums[i]);
            }
            max=Math.max(max,curMAX);
        }
        return max;
    }
}