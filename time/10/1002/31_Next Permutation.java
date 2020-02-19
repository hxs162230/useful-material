31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=n-1;
        while(i>0&&nums[i-1]>=nums[i]) i--;

        int j=n-1;
        if(i>0){
            int cmp = nums[i-1];
            while(nums[j]<=cmp) j--;
            swap(nums,i-1,j);
        }
        reverse(nums,i,n-1);
        
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
}