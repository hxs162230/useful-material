228. Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

T:O(N)

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> lst =new ArrayList<>();
        if(nums.length<=0) return lst;
        for(int i=0;i<nums.length;){
            int start=i;
            int end=i;
            while(end+1<nums.length && nums[end]+1==nums[end+1]){
                end++;
            }
            if(start==end){
                lst.add(String.valueOf(nums[start]));
            }
            else{
                lst.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[end]));
            }
            i=end+1;
            
        }
        return lst;
    }
}