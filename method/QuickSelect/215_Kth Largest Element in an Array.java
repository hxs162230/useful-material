215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

QuickSelect always choose one side to do recursion =>reduce big O complexity
T:O(N) average case 
S:O(1)


class Solution {
    public int findKthLargest(int[] nums, int k) {
        qselect(nums,0,nums.length-1,k);
        return nums[k-1];
    }
    public void qselect(int[] nums,int left,int right,int k){
        if(left>=right) return;
        int pi = partition(nums,left,right);
        if(pi==k-1) return;
        else if(pi<k-1){
            qselect(nums,pi+1,right,k);
        }
        else{
            qselect(nums,left,pi-1,k);
        }
    }
    public int partition(int[] nums,int left,int right){
        int pivot=nums[right];
        int low=left-1;
        for(int i=left;i<right;i++){
            if(nums[i]>pivot){
                low++;
                swap(nums,low,i);
            }
        }
        swap(nums,low+1,right);
        return low+1;
    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}