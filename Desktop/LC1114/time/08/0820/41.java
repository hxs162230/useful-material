41. First Missing Positive
Hard

2237

660

Favorite

Share
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.


但是上面的解法不是 O(1) 的空间复杂度，所以需要另想一种解法，既然不能建立新的数组，
那么只能覆盖原有数组，思路是把1放在数组第一个位置 nums[0]，2放在第二个位置 nums[1]，
即需要把 nums[i] 放在 nums[nums[i] - 1]上，遍历整个数组，如果 nums[i] != i + 1, 
而 nums[i] 为整数且不大于n，另外 nums[i] 不等于 nums[nums[i] - 1] 的话，将两者位置调换，
如果不满足上述条件直接跳过，
最后再遍历一遍数组，如果对应位置上的数不正确则返回正确的数，参见代码如下：

class Solution {
    public int firstMissingPositive(int[] nums) {
        //nums[i]==i+1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] ans,int a,int b){
        int tmp = ans[a];
        ans[a] = ans[b];
        ans[b] = tmp;
    }
}