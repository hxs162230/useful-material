16. 3Sum Closest
Medium

1429

104

Favorite

Share

Given an array nums of n integers and an integer target, 

find three integers in nums such that the sum is closest to target. 

Return the sum of the three integers. 

You may assume that each input would have exactly 

one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ln = nums.length;
        int close = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(target-close);
        
        for(int i=0;i<ln-2;i++){
            
            int left = i+1;
            int right = ln-1;
            
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)<diff){
                    diff = Math.abs(target-sum);
                    close = sum;
                }       
                if(sum>target) right--;
                else if(sum<target) left++;
                else return close;
                } 

            }
            
            return close;
        }
        
        
        
    }