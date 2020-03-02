912. Sort an Array

Given an array of integers nums, sort the array in ascending order.


class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums,int left,int right){
        if(left>=right) return;
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public void merge(int[] nums,int left,int mid,int right){
        int low = left;
        int[] l = new int[mid-left+1];
        int[] r = new int[right-mid];
        for(int i=0;i<mid-left+1;i++){
            l[i] = nums[low++];
        }
        for(int i=0;i<right-mid;i++){
            r[i] = nums[low++];
        }
        low = left;
        int lp = 0;
        int rp = 0;
        while(lp<l.length && rp<r.length){
            if(l[lp]<=r[rp]){
                nums[low++] = l[lp++];
            }
            else{
                nums[low++] = r[rp++];
            }
        }
        while(lp<l.length){
            nums[low++] = l[lp++];
        }
        while(rp<r.length){
            nums[low++] = r[rp++];
        }
    }
}

sol2:

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int pi = partition(nums,left,right);
        quickSort(nums,left,pi-1);
        quickSort(nums,pi+1,right);
    }
    public int partition(int[] nums,int left,int right){
        int low=left-1;
        int pivot = nums[right];
        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                low++;
                swap(nums,i,low);
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