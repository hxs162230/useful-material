Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t 

and the absolute difference between i and j is at most k.
Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

floor greatest value and smaller(<=)
ceil smallest value and larger(>=)

2sum+sliding window variation 

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        
        if(k<0||t<0||nums==null) return false;
        
        for(int i=0;i<nums.length;i++){
            Long u = set.ceiling((long)nums[i]);
            Long d = set.floor((long)nums[i]);
            if((u!=null&&u<=t+nums[i])||(d!=null&&nums[i]<=t+d)) return true;
            set.add((long)nums[i]);
            if(i>=k)
                set.remove((long)nums[i-k]);
        }
        return false;
    }
}