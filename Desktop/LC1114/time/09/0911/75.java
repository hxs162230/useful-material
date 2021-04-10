class Solution {
    public void sortColors(int[] nums) {
        int first=0;
        int end=nums.length-1;
       for(int i=0;i<=end;i++){
            if(nums[i]==0){
               swap(nums,first,i);
               first++;
            }
            else if(nums[i]==2 ){
                swap(nums,end,i);
                end--;
                i--;
            }
     
 
        }
    }
    public void swap(int[] A,int i,int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
}