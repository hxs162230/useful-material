713. Subarray Product Less Than K


Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

这道题给了我们一个数组和一个数字K，让我们求子数组且满足乘积小于K的个数。
既然是子数组，那么必须是连续的，所以肯定不能给数组排序了，这道题好在限定了输入数字都是正数，
能稍稍好做一点。博主刚开始用的是暴力搜索的方法来做的，就是遍历所有的子数组算乘积和K比较，
两个 for 循环就行了，但是 OJ 不答应。于是上网搜大神们的解法，思路很赞。
相当于是一种滑动窗口的解法，维护一个数字乘积刚好小于k的滑动窗口，
用变量left来记录其左边界的位置，右边界i就是当前遍历到的位置。
遍历原数组，用 prod 乘上当前遍历到的数字，然后进行 while 循环，如果 prod 大于等于k，
则滑动窗口的左边界需要向右移动一位，删除最左边的数字，那么少了一个数字，
乘积就会改变，所以用 prod 除以最左边的数字，然后左边右移一位，即 left 自增1。
当我们确定了窗口的大小后，就可以统计子数组的个数了，就是窗口的大小。为啥呢，
比如 [5 2 6] 这个窗口，k还是 100，右边界刚滑到6这个位置，
这个窗口的大小就是包含6的子数组乘积小于k的个数，即 [6], [2 6], [5 2 6]，正好是3个。
所以窗口每次向右增加一个数字，然后左边去掉需要去掉的数字后，
窗口的大小就是新的子数组的个数，每次加到结果 res 中即可，参见代码如下：

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length==0||k<=1) return 0;
        int left=0;
        int right=0;
        int product=1;
        int cnt=0;
        while(right<nums.length){
            product*=nums[right];
            
            while(product>=k&&left<=right){
                product/=nums[left];
                left++;
            }
            cnt += right-left+1;
            right++;
        }
        return cnt;
        
    }
}