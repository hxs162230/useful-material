169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==0) return 0;
        int vote=0;
        int cand=nums[0];
        for(int i:nums){
            if(vote==0){
                cand=i;
                vote++;
            }
            else if(i==cand) vote++;
            else{
                vote--;
            }
        }
        return cand;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int candidate = nums[0];
        int vote = 0;
        for(int num:nums){
            if(num==candidate) vote++;
            else if(vote==0){
                candidate = num;
                vote++;
            }
            else vote--;
        }
        return candidate;
    }
}