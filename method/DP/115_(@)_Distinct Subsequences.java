115. Distinct Subsequences
Hard

1002

50

Add to List

Share
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

class Solution {
    public int numDistinct(String s, String t) {
       
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}



// Let W(i, j) stand for the number of subsequences of S(0, i) equals to T(0, j). If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j); Otherwise, W(i, j) = W(i-1,j).

// public int numDistincts(String S, String T) {
// 	int[][] table = new int[S.length() + 1][T.length() + 1];
 
// 	for (int i = 0; i < S.length(); i++)
// 		table[i][0] = 1;
 
// 	for (int i = 1; i <= S.length(); i++) {
// 		for (int j = 1; j <= T.length(); j++) {
// 			if (S.charAt(i - 1) == T.charAt(j - 1)) {
// 				table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
// 			} else {
// 				table[i][j] += table[i - 1][j];
// 			}
// 		}
// 	}
 
// 	return table[S.length()][T.length()];