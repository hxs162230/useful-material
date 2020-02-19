560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


论坛上大家比较推崇的其实是这种解法，用一个哈希表来建立连续子数组之和跟其出现次数之间的映射，
初始化要加入 {0,1} 这对映射，这是为啥呢，因为我们的解题思路是遍历数组中的数字，用 sum 来记录到当前位置的累加和，
我们建立哈希表的目的是为了让我们可以快速的查找 sum-k 是否存在，即是否有连续子数组的和为 sum-k，如果存在的话，
那么和为k的子数组一定也存在，这样当 sum 刚好为k的时候，那么数组从起始到当前位置的这段子数组的和就是k，
满足题意，如果哈希表中事先没有 m[0] 项的话，这个符合题意的结果就无法累加到结果 res 中，这就是初始化的用途。



T:O(N)
S:O(N)
此類問題記得HashMap的初始化



class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> preSum=new HashMap<>();
        int sum=0;
        int res=0;
        preSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(preSum.containsKey(sum-k))
                res+=preSum.get(sum-k); 
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return res;
    }
}