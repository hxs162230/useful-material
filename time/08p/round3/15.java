15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

T:O(N*N+NlogN)
S:O(N*N)
remove duplicate tuples操作

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0) return res;
        //List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;nums[0]<=0&&i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while(left<right){
                if(nums[left]+nums[right]<target){
                    left++;
                }
                else if(nums[left]+nums[right]>target){
                    right--;
                }
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    right--;
                    left++;
                }
                
            }
            while(i+1<nums.length-2&&nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}