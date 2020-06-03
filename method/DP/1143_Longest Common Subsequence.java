1143. Longest Common Subsequence
Medium

1089

14

Add to List

Share
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}



// time complexity - O(m*n)
// space complexity - O(m*n)
class Solution {
    int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        cache = new int[n1][n2];
        return dfs(n1,n2,text1,text2,0,0);
    }
    public int dfs(int n1,int n2,String s1,String s2,int i,int j){
        if(i==n1||j==n2) return 0;
        if(cache[i][j]!=0) return cache[i][j];
        int ans = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans = cache[i][j] = dfs(n1,n2,s1,s2,i+1,j+1)+1;
        }
        else{
            ans = cache[i][j] =  Math.max(ans,Math.max(dfs(n1,n2,s1,s2,i+1,j),dfs(n1,n2,s1,s2,i,j+1)));
        }
        return ans;
    }
}