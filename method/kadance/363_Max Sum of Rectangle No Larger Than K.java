363. Max Sum of Rectangle No Larger Than K
Hard

683

49

Add to List

Share
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
Note:

The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //kadance's algorithms
        //maxsum
        //cursum
        //maxleft maxtop maxbot maxright

        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
    //outer loop should use smaller axis
    //now we assume we have more rows than cols, therefore outer loop will be based on cols 
        for(int i=0;i<n;i++){
            int[] row = new int[m];
            for(int j=i;j<n;j++){
                for(int r=0;r<m;r++){
                    row[r] += matrix[r][j];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                //Find the max subarray no more than K 
                //curSum - sum <= k  ===> sum >= curSum-k
                for(int s:row){
                    curSum+=s;
                    Integer sum = set.ceiling(curSum-k);
                    if(sum!=null) res = Math.max(res,curSum-sum);
                    set.add(curSum);
                }
            }
        }
        return res;
    }
}
