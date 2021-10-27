1277. Count Square Submatrices with All Ones
Medium

2673

42

Add to List

Share
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

class Solution {
    public int countSquares(int[][] matrix) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        //biggest square count from bottom right
        int[][] dp = new int[xlen+1][ylen+1];
        
        int ans = 0;
        for(int i=1;i<=xlen;i++){
            for(int j=1;j<=ylen;j++){
                if(matrix[i-1][j-1]==1){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
                //System.out.print(dp[i][j]+",");
                ans+=dp[i][j];                            
            }
            //System.out.println();
        }
        
        
        return ans;
    }
}