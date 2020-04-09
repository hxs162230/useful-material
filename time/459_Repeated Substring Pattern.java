459. Repeated Substring Pattern
Easy

1234

136

Add to List

Share
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps  = kmp(s);
        int n = s.length();
        //for(int i:lps) System.out.print(i);
        //To check if the string is repeating itself, we just need the last entry to be non-zero and str.size() to divide (str.size()-last entry).
        return lps[n-1]>0&&n%(n-lps[n-1])==0;
    }
    public int[] kmp(String s){
        int[] lps = new int[s.length()];
        int i=1;
        int len=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                lps[i++] = ++len;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    lps[i++] = len;
                }
            }
        }
        return lps;
    } 
}