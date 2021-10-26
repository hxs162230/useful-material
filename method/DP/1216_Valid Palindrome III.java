1216. Valid Palindrome III
Hard

157

4

Add to List

Share
Given a string s and an integer k, find out if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.

 

Example 1:

Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.
 

Constraints:

1 <= s.length <= 1000
s has only lowercase English letters.
1 <= k <= s.length


O(MN)
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int len = lcs(s,new StringBuilder(s).reverse().toString());
        //System.out.print(len);
        return s.length()-len<=k;
    }
    public int lcs(String s,String p){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}