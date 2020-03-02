480. Sliding Window Median
Hard

545

56

Favorite

Share
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> lhs = new PriorityQueue<>(Collections.reverseOrder()); //maxheap
        PriorityQueue<Integer> rhs = new PriorityQueue<>(); //minheap
        double[] res = new double[nums.length-k+1];
        double median=0;
        for(int i=0;i<nums.length;i++){
                lhs.add(nums[i]);
                rhs.add(lhs.poll());
                if(lhs.size()<rhs.size()){
                    lhs.add(rhs.poll());
                }
                if(lhs.size()+rhs.size()==k){
                    if(lhs.size()>rhs.size()) median = (double) lhs.peek();
                    else median = (double)((long)lhs.peek()+(long)rhs.peek())/2;
                }
                if(i-k+1>=0){ 
                    res[i-k+1] = median;
                    if(!lhs.remove(nums[i-k+1])){
                    rhs.remove(nums[i-k+1]);
                }
            }
                
        }
        return res;
    }
}
