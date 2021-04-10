1130. Minimum Cost Tree From Leaf Values

Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  
(Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  
It is guaranteed this sum fits into a 32-bit integer.

 

Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4
 

Constraints:

2 <= arr.length <= 40
1 <= arr[i] <= 15
It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).

dp[][] min cost tree in interval


class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp  = new int[n][n];
        int[][] maxInterval = new int[n][n];
        for(int[] ds:dp){
            Arrays.fill(ds,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
            maxInterval[i][i] = arr[i];
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j = i+len-1;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+maxInterval[i][k]*maxInterval[k+1][j]);
                }
                for(int k=i;k<=j;k++){
                    maxInterval[i][j] = Math.max(maxInterval[i][j],arr[k]);
                }
            }
        }
        return dp[0][n-1];
    }
}



class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        
        for(int level = 2 ; level <= len; level++) {
            for(int i = 0; i <= len - level; i++) {
                int j = i + level - 1;
                for(int k = i; k < j; k++) {
                    if(dp[i][j] != 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (getMax(arr, i, k) * getMax(arr, k + 1, j)));
                    else 
                        dp[i][j] = dp[i][k] + dp[k+1][j] + (getMax(arr, i, k) * getMax(arr, k + 1, j));
                }
            }
        }
        return dp[0][len - 1];
    }
    private int getMax(int[] arr, int i, int j) {
            int max = Integer.MIN_VALUE;
            for(int k = i; k <=j ; k++) {
                max = Math.max(max, arr[k]);
            }
            return max;
        }
}

