219. Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]) && i-hm.get(nums[i])<=k){
                
                return true;
                
            }
            hm.put(nums[i],i);
               
            }
        return false;
    }
}