658. Find K Closest Elements
Medium

1065

210

Add to List

Share
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
UPDATE (2017/9/19):
The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.



// Assume we are taking A[i] ~ A[i + k -1].
// We can binary research i
// We compare the distance between x - A[mid] and A[mid + k] - x

// If x - A[mid] > A[mid + k] - x,
// it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
// and we have mid smaller than the right i.
// So assign left = mid + 1.

// Note that, you SHOULD NOT compare the absolute value of abs(x - A[mid]) and abs(A[mid + k] - x).
// It fails at cases like A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3

//找!!!!!!!!!!!!!!!!第一個 arr[m]+arr[m+k] >= 2x 
//
//
//注意這裡是比較k+1項 arr[m]+arr[m+k] 不是 arr[m]+arr[m+k-1]
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res= new ArrayList<>();
        int left = 0;
        int right = arr.length-k;
        while(left<right){
            int m = left+(right-left)/2;
            if(arr[m+k]-x>=x-arr[m]){
                right = m;
            }
            else{
                left = m+1;
            }
                
        }
        
        for(int i=right;i<=right+k-1;i++) res.add(arr[i]);
        
        return res;
    }
}