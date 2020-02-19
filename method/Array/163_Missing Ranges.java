163. Missing Ranges

Given a sorted integer array nums, where the range of elements are in the inclusive range 

[lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> lst = new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            long start = i==0? lower : (long)nums[i-1]+1 ;
            long end = i==nums.length ? upper : (long)nums[i]-1;
            addString(lst,start,end);
        }
        return lst;
    }
    public void addString(List<String> lst,long s,long e){
        if(s<e){
            lst.add(String.valueOf(s)+"->"+String.valueOf(e));
        }
        else if(s==e){
            lst.add(String.valueOf(s));
        }
        else
            return;
    }
}