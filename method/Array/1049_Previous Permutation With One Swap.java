1053. Previous Permutation With One Swap
Medium

109

206

Add to List

Share
Given an array A of positive integers (not necessarily distinct), return the lexicographically largest permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  If it cannot be done, then return the same array.

 

Example 1:

Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
Example 2:

Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
Example 3:

Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.
Example 4:

Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.
 

Note:

1 <= A.length <= 10000
1 <= A[i] <= 10000


similar to next permutation number
time O(N)
space O(1)

class Solution {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        int i = n-1;
        //decreasing from right find the first digit j break the rule
        while(i>0&&A[i-1]<=A[i]) i--;
        if(i==0) return A;
        int j = i-1;
        
        int k= n-1;

        //find first digit smaller than j from right;
        while(k>j&&A[k]>=A[j]) k--;
        
        //case 2113   = >  1213  findleftMost digit 1 (last smaller or equal to from right)
        while(k>0&&A[k]==A[k-1]) k--;
        
        
        swap(A,j,k);
        return A;
    }
    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}