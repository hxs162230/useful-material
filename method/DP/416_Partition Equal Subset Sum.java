416. Partition Equal Subset Sum

Given a non-empty array containing only positive integers, 

find if the array can be partitioned into two subsets such that the sum of 

elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.

我们定义一个一维的dp数组，其中dp[i]表示原数组是否可以取出若干个数字，其和为i。那么我们最后只需要返回dp[target]就行了

class Solution {
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2==1) return false;
        sum/=2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;


        for(int num:nums){
            for(int j=sum;j>=num;j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[sum];
    }
}