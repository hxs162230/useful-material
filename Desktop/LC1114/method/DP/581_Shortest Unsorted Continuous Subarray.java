581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that 

if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

这道题给了我们一个数组，让我们求最短的无序连续子数组，
根据题目中的例子也不难分析出来是让我们找出数组中的无序的部分。
那么我最开始的想法就是要确定无序子数组的起始和结束位置，这样就能知道子数组的长度了。
所以我们用一个变量start来记录起始位置，然后我们开始遍历数组，当我们发现某个数字比其前面的数字要小的时候，
说明此时数组不再有序，所以我们要将此数字向前移动，移到其应该在的地方，我们用另一个变量j来记录移动到的位置，
然后我们考虑要不要用这个位置来更新start的值，当start还是初始值-1时，肯定要更新，因为这是出现的第一个无序的地方，
还有就是如果当前位置小于start也要更新，这说明此时的无序数组比之前的更长了。我们举个例子来说明，
比如数组[1,3,5,4,2]，第一个无序的地方是数字4，它移动到的正确位置是坐标2，此时start更新为2，
然后下一个无序的地方是数字2，它的正确位置是坐标1，所以此时start应更新为1，这样每次用i - start + 1
来更新结果res时才能得到正确的结果，参见代码如下：
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int j=0;
        int start=-1;
        int res =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                    j=i;
                while(j>0 && nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                    j--;
                }
                if(start==-1||j<start) start=j;
                res = i-start+1;
            }
        }
        return res;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}