611. Valid Triangle Number

Given an array consists of non-negative integers, 

your task is to count the number of triplets chosen from the array that can make triangles 

if we take them as side lengths of a triangle.

    
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].

其实还有更进一步优化的方法，用的是博主之前那篇3Sum Smaller里面的解法二，
明明博主以前都总结过，换个题目情景就又没想到，看来博主的举一反三能力还是有所欠缺啊。
没办法，只能继续刻意练习了。这种方法能将时间复杂度优化到O(n2), 感觉很叼了。思路是排序之后，
从数字末尾开始往前遍历，将left指向首数字，将right之前遍历到的数字的前面一个数字，
然后如果left小于right就进行循环，循环里面判断如果left指向的数加上right指向的数大于当前的数字的话，那么right到left之间的数字都可以组成三角形，
这是为啥呢，相当于此时确定了i和right的位置，可以将left向右移到right的位置，
中间经过的数都大于left指向的数，所以都能组成三角形，就说这思路叼不叼！加完之后，right自减一，
即向左移动一位。如果left和right指向的数字之和不大于nums[i]，那么left自增1，即向右移动一位，
参见代码如下：

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length<3) return 0;
        int res=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            int left = 0;
            int right = i-1;
            while(left<right){
                if(nums[left]+nums[right]<=nums[i]){
                    left++;
                }
                else{
                    res+=right-left;
                    right--;
                }
            }
        }
        return res;
    }
}