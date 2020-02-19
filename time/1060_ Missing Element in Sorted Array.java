1060. Missing Element in Sorted Array
Medium

148

3

Favorite

Share
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

 

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 

Note:

1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8

T:O(log(N))
S:O(1)

class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length-1;
        int gap = nums[n]-nums[0]-(n-0);
        if(k>gap) return nums[n]+k-gap;
        int left = 0;
        while(n-left>1){
            int mid = left+(n-left)/2;
            int missing = nums[mid]-nums[left]-(mid-left);
            if(k>missing){
                k-=missing;
                left = mid;
            }
            else{
                n = mid;
            }
        }
        return nums[left]+k;
    }
}