###buckets sort method O(N)


164. Maximum Gap
Hard

1035

200

Add to List

Share
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.


class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len<2) return 0;
        int min = nums[0];
        int max = nums[0];
        for(int i:nums){
            max = Math.max(i,max);
            min = Math.min(i,min);
        }
        
        //minimun distances gap
        int gap = (int)Math.ceil((double)(max-min)/(len-1));
        if(gap==0) return 0;
        
        //numbers of blocks
        int blocks = (max-min)/gap+1;
        int[][] buckets = new int[blocks][2];
        for(int i=0;i<blocks;i++){
            for(int j=0;j<2;j++){
                buckets[i][0] = Integer.MAX_VALUE;
                buckets[i][1] = Integer.MIN_VALUE;
            }
        }
        
        for(int i:nums){
            
            int idx = (i-min)/gap;
            //min
            buckets[idx][0] = Math.min(buckets[idx][0],i);
            //max
            buckets[idx][1] = Math.max(buckets[idx][1],i);
        }
        
        int pre = min;
        int maxgap = Integer.MIN_VALUE;
        for(int idx=0;idx<blocks;idx++){
            if(buckets[idx][0]==Integer.MAX_VALUE||buckets[idx][1]==Integer.MIN_VALUE) continue;
            maxgap = Math.max(maxgap,buckets[idx][0]-pre);
            pre = buckets[idx][1];
        }
        maxgap = Math.max(maxgap,max-pre);
        
        return maxgap;
    }
}



 0~9;10~19;20~29;30~39
|____|____|____|____|