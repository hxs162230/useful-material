18. 4Sum
Medium

1552

290

Add to List

Share
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int left=j+1;
                int right=nums.length-1;
                int t = target-nums[i]-nums[j];
                while(left<right){
                    if(nums[left]+nums[right]<t){
                        left++;
                    }
                    else if(nums[left]+nums[right]>t){
                        right--;
                    }
                    else{
                        lol.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
                while(j+1<nums.length-2 && nums[j]==nums[j+1]) j++;
            }
            while(i+1<nums.length-3 && nums[i]==nums[i+1]) i++;
        }
        return lol;
    }
}