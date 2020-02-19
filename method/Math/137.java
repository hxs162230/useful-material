137. Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
       
        for(int i=0;i<nums.length;i++){
            
            for(int j=0;j<32;j++){
                if((nums[i]&1)==1)
                	arr[arr.length-1-j]+=(nums[i]&1);
                nums[i]>>=1;
            }
            
        }
        
        int sum=0;
        for(int i=0;i<32;i++){
            sum<<=1;
            sum+=arr[i]%3;
        }
        return sum;
    }
}