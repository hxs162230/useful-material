260. Single Number III

Given an array of numbers nums, 
in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

我们取出其中任意一位为 ‘1’ 的位，为了方便起见，我们用 a &= -a 来取出最右端为 ‘1’ 的位



class Solution {
    public int[] singleNumber(int[] nums) {
        int len=nums.length;
        int diff=0;
        for(int i=0;i<len;i++){
            
            diff^=nums[i];
        
        }
        
        diff&=-diff;
        int[] s =new int[2];
        
        for(int i=0;i<len;i++){
            
            if((nums[i]&diff)==0)
                s[1]^=nums[i];
            else
                s[0]^=nums[i];
            
        }
        return s;
    }
}