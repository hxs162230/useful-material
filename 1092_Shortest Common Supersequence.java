1092. Shortest Common Supersequence
Hard

826

24

Add to List

Share
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
 

Note:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.


class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m+1][n+1];
    
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0) dp[i][j] = j;
                else if(j==0) dp[i][j] = i;
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        //System.out.print(dp[m][n]);
        
        int L = dp[m][n];
        char[] res = new char[L];
        int i = m;
        int j = n;
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res[--L] = str1.charAt(i-1);
                i--;
                j--;
            }
            //find smallest one 
            else if(dp[i-1][j]<dp[i][j-1]){
                res[--L] = str1.charAt(i-1);
                i--;
            }
            else{
                res[--L] = str2.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            res[--L] = str1.charAt(i-1);
            i--;
        }
        while(j>0){
            res[--L] = str2.charAt(j-1);
            j--;
        }
        
        return new String(res);
    }
}