91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


T:O(N)
S:O(N)
dp[i] numOfWays when len=i
此題目是climbing stair的變種

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<s.length()+1;i++){
            dp[i]+=(s.charAt(i-1)=='0'?0:dp[i-1]);
            if(i>=2&&Integer.parseInt(s.substring(i-2,i))>=10&&Integer.parseInt(s.substring(i-2,i))<=26)
            dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
}