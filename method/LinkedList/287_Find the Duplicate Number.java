287. Find the Duplicate Number



Given an array nums containing n + 1 integers 

where each integer is between 1 and n (inclusive), prove that 

at least one duplicate number must exist. 

Assume that there is only one duplicate number, find the duplicate one.


You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

由于题目限定了区间 [1,n]，所以可以巧妙的利用坐标和数值之间相互转换，而由于重复数字的存在，
那么一定会形成环，我们用快慢指针可以找到环并确定环的起始位置，确实是太巧妙了！

 

class Solution {
    public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];      
        }
        if(slow==0) return -1;
        int start = 0;  
        while(start!=slow){
            start=nums[start];
            slow=nums[slow];
        }
        return slow;
    }
}