33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. 

If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

這題重點是沒有重複 所以不需要right--去找到不一樣的值 詳閱LC81

再來邏輯是
找到"有序"半邊作判斷 若target落在有序區間則對此區間進行查找
                  若不在此區間 轉往另一半邊作查找

此題可用left邊界列條件式 但邊界條件更複雜
請看sol2

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(target<nums[mid]&&target>=nums[left])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}


看了上面的解法，你可能会产生个疑问，为啥非得用中间的数字跟最右边的比较呢？

难道跟最左边的数字比较不行吗，当中间的数字大于最左边的数字时，左半段也是有序的啊，

如下所示（蓝色表示中点之前一定为有序的）：

0　　1　　2　　 4　　5　　6　　7

7　　0　　1　　 2　　4　　5　　6

6　　7　　0　　 1　　2　　4　　5

5　　6　　7　　 0　　1　　2　　4

4　　5　　6　　7　　0　　1　　2

2　　4　　5　　6　　7　　0　　1

1　　2　　4　　5　　6　　7　　0

貌似也可以做，但是有一个问题，那就是在二分搜索中，nums[mid] 和 nums[left] 还有可能相等的，
当数组中只有两个数字的时候，比如 [3, 1]，那么我们该去取那一边呢？由于只有两个数字且 nums[mid] 
不等于 target，那么 target 只有可能在右半边出现。那么最好的方法就是让其无法进入左半段，
那么就需要左半段是有序的，而且由于一定无法同时满足 nums[left] <= target && nums[mid] > target，因
为 nums[left] 和 nums[mid] 相等，同一个数怎么可能同时大于等于 target，又小于 target。由于这个条件不满足，
则直接进入右半段继续搜索即可，所以等于的情况要加到 nums[mid] > nums[left] 的情况中，变成大于等于，参见代码如下：

sol2:
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
};