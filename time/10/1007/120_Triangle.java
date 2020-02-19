120. Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        int r=0;
        int c=0;
        dp[0][0] = triangle.get(0).get(0);
        

        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0)
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                else if(j==triangle.get(i).size()-1)
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
 
        for(int i:dp[triangle.size()-1]) min=Math.min(i,min); 
        return min;
    }
}