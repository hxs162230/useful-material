562. Longest Line of Consecutive One in Matrix
Medium

299

70

Add to List

Share
Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.


class Solution {
    public int longestLine(int[][] M) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        if(M==null||M.length==0||M[0].length==0) return 0;
        int m = M.length;
        int n = M[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int[] dig = new int[m+n-1];
        int[] anti_dig = new int[m+n-1];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1){
                    col[j]++;
                    row[i]++;
                    dig[i+j]++;
                    anti_dig[j-i+m-1]++;
                    max = Math.max(max,col[j]);
                    max = Math.max(max,row[i]);
                    max = Math.max(max,dig[i+j]);
                    max = Math.max(max,anti_dig[j-i+m-1]);
                }
                else if(M[i][j]==0){
                    col[j] = 0;
                    row[i] = 0;
                    dig[i+j] = 0;
                    anti_dig[j-i+m-1] = 0;
                }
            }
       }
       return max;
    }
}