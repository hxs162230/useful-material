303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

T:O(N) for NumArray and O(1) for sumRange
S:O(N)


class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        if(nums.length<=0) return;
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i<=0) return preSum[j];
        return preSum[j] - preSum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {
    int[] pre;
    public NumArray(int[] nums) {
        pre = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            pre[i] = pre[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if(j<i) return 0;
        return pre[j+1]-pre[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */