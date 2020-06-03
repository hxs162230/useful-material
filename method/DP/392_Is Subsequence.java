392. Is Subsequence
Easy

1034

180

Add to List

Share
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.


class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[t.length()+1][s.length()+1];
        for(int i=0;i<=t.length();i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=t.length();i++){
            for(int j=1;j<=s.length();j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = t.length();
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=m;i++){
            for(int j=n;j>0;j--){
                if(s.charAt(j-1)==t.charAt(i-1))
                    dp[j] = dp[j]||dp[j-1];
            }
        } 
        return dp[n];
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int slen = s.length();
        int tlen = t.length();
        int s_idx = 0;
        int t_idx = 0;
        while(t_idx<tlen){
            if(s.charAt(s_idx)==t.charAt(t_idx)){
                s_idx++;
                if(s_idx==slen) return true;
            }
            t_idx++;
        }
        return false;
    }
}

