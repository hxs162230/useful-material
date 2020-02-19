493. Reverse Pairs

Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.


class Solution {
    private int res=0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        //System.out.println(res);
        return res;
    }
    public void mergeSort(int[] nums,int left,int right){
        if(left>=right) return ;
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int l=left;
        int r=mid+1;
        //System.out.println("left "+nums[l]+" right "+nums[r]);
        while(l<=mid && r<=right){
            if((long)nums[l]>(long)2*nums[r]){
            res+=mid-l+1;
            r++;
            //System.out.println(r);
            }
            else
            l++;
        }
        merge(nums,left,mid,right);
        // for(int num:nums){
        // System.out.print(num+" ");
        // }
        // System.out.println();
    }
    public void merge(int[] nums,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] leftSide = new int[n1];
        int[] rightSide =new int[n2];
        for(int i=0;i<n1;i++){
            leftSide[i]=nums[i+left];
        }
        for(int i=0;i<n2;i++){
            rightSide[i]=nums[i+mid+1];
        }
        int l=0;
        int r=0;
        int k=left;
        while(l<n1 && r<n2){
            if(leftSide[l]<=rightSide[r]){
               nums[k]=leftSide[l]; 
               l++;
            }
            else{
               nums[k]=rightSide[r];
               r++;
            }
            k++;
        }
        while(l<n1){
            nums[k++]=leftSide[l++];
        }
        while(r<n2){
            nums[k++]=rightSide[r++];
        }   
    }
}
