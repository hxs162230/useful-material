442. Find All Duplicates in an Array
Medium

1362

125

Favorite

Share
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

这类问题的一个重要条件就是1 ≤ a[i] ≤ n (n = size of array)，不然很难在O(1)空间和O(n)
时间内完成。首先来看一种正负替换的方法，这类问题的核心是就是找nums[i]和nums[nums[i] - 1]的关系，
我们的做法是，对于每个nums[i]，我们将其对应的nums[nums[i] - 1]
取相反数，如果其已经是负数了，说明之前存在过，我们将其加入结果res中即可，参见代码如下：

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val]<0)
                lst.add(val+1);
                nums[val]=-nums[val];
        }
        return lst;
    }
}