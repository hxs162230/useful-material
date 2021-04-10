239. Sliding Window Maximum
Hard

2212

128

Favorite

Share
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

T:O(N)
S:O(N)
// 用双向队列保存数字的下标，遍历整个数组，如果此时队列的首元素是 i-k 的话，
// 表示此时窗口向右移了一步，则移除队首元素。
// 然后比较队尾元素和将要进来的值，如果小的话就都移除，
// 然后此时我们把队首元素加入结果中即可，参见代码如下：
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0) return new int[0];
        int[] max =new int[nums.length-k+1];
        Deque<Integer> deq = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!deq.isEmpty()&&nums[deq.peekLast()]<nums[i]){
                
                deq.removeLast();
            }
            if(!deq.isEmpty()&&deq.peekFirst() < i-k+1){
                deq.removeFirst();
            }
            deq.addLast(i);//add last idx;
            if(i-k+1>=0){
                max[i-k+1] = nums[deq.peekFirst()];              
            }
    }
        return max;
}
}