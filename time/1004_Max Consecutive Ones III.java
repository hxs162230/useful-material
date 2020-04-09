1004. Max Consecutive Ones III
Medium

722

19

Add to List

Share
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 

Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1 

sliding window O(n)
class Solution {
    public int longestOnes(int[] A, int K) {
        int right = 0;
        int left= 0;
        int max =0;
        while(right<A.length){
            if(A[right]==0) K--;
            while(K<0){
                if(A[left]==0) K++;
                left++;
            }
            max = Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}