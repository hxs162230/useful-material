
378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.


上面的解法还可以进一步优化到 O(nlgX)，其中X为最大值和最小值的差值，我们并不用对每一行都做二分搜索法，
我们注意到每列也是有序的，我们可以利用这个性质，从数组的左下角开始查找，如果比目标值小，我们就向右移一位，
而且我们知道当前列的当前位置的上面所有的数字都小于目标值，那么 cnt += i+1，
反之则向上移一位，这样我们也能算出 cnt 的值。其余部分跟上面的方法相同，参见代码如下：

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left =0;
        int right =matrix[m-1][n-1];
        while(left<right){
            int mid = left+(right-left)/2;
            int count = getcnt(matrix,mid,0);
            if(count<k)
                left=mid+1;
            else
                right=mid;
        }
        return right;
    }
    public int getcnt(int[][] m,int target,int cnt){
        int j=0;
        int i=m.length-1;
        while(j<m[0].length && i>=0){
            if(m[i][j]>target){
                i--;
            }
            else{
                cnt+=i+1;
                j++;
            }
        }
        return cnt;
    }
}