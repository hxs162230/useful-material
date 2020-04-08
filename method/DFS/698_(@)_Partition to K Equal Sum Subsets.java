698. Partition to K Equal Sum Subsets

Given an array of integers nums and a positive integer k, find whether it's 
possible to divide this array into k non-empty subsets whose sums are all equal.

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums) 
            sum+=num;
        if(sum%k!=0) return false;
        boolean[] seen = new boolean[nums.length];
        //Arrays.sort(nums);
        return recur(nums,seen,0,0,sum/k,k);        
    }
    public boolean recur(int[] nums,boolean[] seen,int start,int cursum,int target,int k){
        
        if(cursum==target) return recur(nums,seen,0,0,target,k-1);
        if(k==0) return true;
        //if(cursum>target) return false;
        for(int i=start;i<nums.length;i++){
            if(seen[i]) continue;
            seen[i]=true;
            if(recur(nums,seen,i+1,cursum+nums[i],target,k)) return true;
            seen[i]=false;
        }
        return false;
    }
}