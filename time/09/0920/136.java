136. Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

class Solution {
    public int singleNumber(int[] nums) {
        //a^a=0 a^0=a
        int a=0;
        for(int i=0;i<nums.length;i++){
               a^=nums[i];
            
        }
        return a;
    }
}