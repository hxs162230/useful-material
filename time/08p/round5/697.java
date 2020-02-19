697. Degree of an Array

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

T:O(N)
S:O(N)


class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new int[]{1,i,i});
            else{
                int[] tmp = map.get(nums[i]);
                ++tmp[0];
                tmp[2]=i;
            }
        }
        int res = Integer.MAX_VALUE;
        int deg = Integer.MIN_VALUE;
        for(int[] idx:map.values()){
            if(idx[0]>deg){
                res = idx[2]-idx[1]+1;
                deg = idx[0];
            }
            else if(idx[0]==deg){
                res = Math.min(res,idx[2]-idx[1]+1);
            }
        }
        return res;
    }
}