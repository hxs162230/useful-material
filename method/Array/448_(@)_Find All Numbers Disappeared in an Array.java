448. Find All Numbers Disappeared in an Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

Each time when a new value X is read, it changes the corresponding Xth number 
(value at index X-1) into negative, indicating value X is read for the first time

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0)
                nums[idx]=-nums[idx];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                lst.add(i+1);
        }
        return lst;
    }
    
}