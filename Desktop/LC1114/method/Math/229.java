229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

我们要尽可能的先对候选数字进行累加，而不是先进行更换。若改变了顺序，
对于这个例子 [8, 8, 7, 7, 7] 的话，会将两个候选数字都变成8，然后当遍历到第一个7的时候，
两个候选数字的计数同时减为0，这样最后只能得到7，而正确答案是8和7。

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //only two
        
        int vote1=0,vote2=0;
        int res1=0 ,res2=0;
        int num1=0,num2=0;
        List<Integer> lst= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(res1==nums[i]) vote1++;
            else if(res2==nums[i]) vote2++;
            else if(vote1==0){
                vote1++;
                res1=nums[i];
            }
            else if(vote2==0){
                    vote2++;
                    res2=nums[i];
            }
            
            else{ vote1--; vote2--;

                }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==res1) num1++;
            else if(nums[i]==res2) num2++;
            
        }
        if(num1>nums.length/3)  lst.add(res1);
        if(num2>nums.length/3)  lst.add(res2);
        return lst;
        
        
    }
}