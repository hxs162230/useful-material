525. Contiguous Array

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.


T:O(N)
S:O(N)
因為是求最長子數組 只有當 map.containsKey == false時放入其映射



class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                nums[i]=-1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int res=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-0)){
                res=Math.max(res,i-map.get(sum-0));
            }
            else{
                map.put(sum,i);
            }
        }
        return res;
    }
}