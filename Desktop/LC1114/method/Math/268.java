268. Missing Number
Easy

1148

1552

Favorite

Share
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

那么思路是既然0到n之间少了一个数，我们将这个少了一个数的数组合0到n之间完整的数组异或一下，
那么相同的数字都变为0了，剩下的就是少了的那个数字了，参加代码如下：
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans^=(i+1)^nums[i];
            
        }
        return ans;
        
    }
}