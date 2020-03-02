315. Count of Smaller Numbers After Self
Hard

1497

62

Favorite

Share
You are given an integer array nums and you have to return a new counts array. 

The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.


The basic idea is to do merge sort to nums[]. To record the result, we need to keep the index of each number in the original array. So instead of sort the number in nums, we sort the indexes of each number.
Example: nums = [5,2,6,1], indexes = [0,1,2,3]
After sort: indexes = [3,1,0,2]

While doing the merge part, say that we are merging left[] and right[], left[] and right[] are already sorted.

We keep a rightcount to record how many numbers from right[] we have added and keep an array count[] to record the result.

When we move a number from right[] into the new sorted array, we increase rightcount by 1.

When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.

This solution is really awesome! Here is my understanding for real meaning behind the variable rightcount . This variable denotes the number of elements in the right sorted part that are smaller than the next element from the left sorted part. Why are they smaller than the next element from the left sorted part? Because they come before (the next element from the left sorted part) in the merged array. That how this sentence follows : When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.

Or another version: We keep the rightcount for the next number, because this next number could come from the left sorted array, and when this is the case, we know previously there were rightcount number of elements that are smaller than it.

class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        int[] idx = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<idx.length;i++){
            idx[i]=i;
        }
        mergeSort(nums,0,nums.length-1,idx);
        for(int c:count){
            res.add(c);
        }
        return res;
    }
    public void mergeSort(int[] nums,int left,int right,int[] idx){
        if(left>=right) return ;
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid,idx);
        mergeSort(nums,mid+1,right,idx);
        merge(nums,left,mid,right,idx);
    }
    public void merge(int[] nums,int left,int mid,int right,int[] idx){
        int sort_idx = 0;
        int l = left;
        int r = mid+1;
        int right_cnt = 0;
        int[] new_idx = new int[right-left+1];
        while(l<=mid && r<=right){
            if( nums[idx[r]] < nums[idx[l]] ){
                new_idx[sort_idx] = idx[r];
                right_cnt++;
                r++;
            }
            else{
                new_idx[sort_idx] = idx[l];
                count[idx[l]]+=right_cnt;
                l++;
            }
            sort_idx++;
        }
        while(l<=mid){
            new_idx[sort_idx]=idx[l];
            count[idx[l]] += right_cnt;
            sort_idx++;
            l++;
        }
        while(r<=right){
            new_idx[sort_idx++] = idx[r++];
        }
        
        for(int i=left;i<=right;i++){
            idx[i]=new_idx[i-left];
        }
    }
}
