128. Longest Consecutive Sequence
Hard

2303

131

Favorite

Share
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        
        int len=0;
        for(int num:nums){
            if(!hs.contains(num)) continue;
            
              int val = num;
              int next = val+1;
              int pre = val-1;
              hs.remove(num);
              while(hs.contains(next)){
              hs.remove(next);
              next++;
              }
              while(hs.contains(pre)){
              hs.remove(pre);
              pre--;
              }
              len = Math.max(len,next-pre-1);// next++ pre-- 多2
        }
        return len;
    }
}