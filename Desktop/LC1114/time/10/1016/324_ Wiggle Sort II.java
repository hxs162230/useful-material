324. Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?


class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = (n-1)/2;
        int median = quickSelect(nums,0,n-1,m);
        int high=n-1;
        int low=0;

        //color sort+virtual indexing
        for(int i=0;i<=high;i++){
            if(nums[index(i,n)]>median){
                swap(nums,index(i,n),index(low++,n));
            }
            else if(nums[index(i,n)]<median){
                swap(nums,index(i--,n),index(high--,n));
            }
        }
        
        
        
    }
    public int index(int i,int n){
        return (i*2+1)%(n|1);                         | bitwise OR (a greater odd number)
    }
    public int quickSelect(int[] nums,int left,int right,int m){
        int pivot = partition(nums,left,right);
        if(pivot<m)
            return quickSelect(nums,pivot+1,right,m);
        else if(pivot>m)
            return quickSelect(nums,left,pivot-1,m);
        else
            return nums[m];
    }
    public int partition(int[] nums,int left,int right){
        int low = left-1;
        int pivot = nums[right];
        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                low++;
                swap(nums,low,i);
            }
        }
        swap(nums,low+1,right);
        return low+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}