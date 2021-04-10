55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

其实这题最好的解法不是DP，而是贪婪算法Greedy Algorithm，因为我们并不是很关心每一个位置上的剩余步数，
我们只希望知道能否到达末尾，也就是说我们只对最远能到达的位置感兴趣，所以我们维护一个变量reach，
表示最远能到达的位置，初始化为0。遍历数组中每一个数字，
如果当前坐标大于reach或者reach已经抵达最后一个位置则跳出循环，
否则就更新reach的值为其和i + nums[i]中的较大值，其中i + nums[i]表示当前位置能到达的最大位置，
代码如下：

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=0) return false;
        int maxidx=0;
        
        for(int i=0;i<nums.length;i++){
            if(i>maxidx) return false; //無法到達當前位置i 返回F
            maxidx = Math.max(maxidx,nums[i]+i); //當前位置所能到達的最大值
        }
        return true;
      
    }
}