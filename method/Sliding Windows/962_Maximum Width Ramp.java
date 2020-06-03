962. Maximum Width Ramp
Medium

479

15

Add to List

Share
Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

 

Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 

Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000


class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int[] max = new int[n];
        Arrays.fill(max,A[n-1]);

        for(int i=n-2;i>=0;i--){
            max[i] = Math.max(max[i+1],A[i]);
        }
        //two pointer method
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<n){
            while(left<right&&A[left]>max[right]){
                left++;
            }
            res = Math.max(res,right-left);
            right++;
        }
        return res;
    }
}