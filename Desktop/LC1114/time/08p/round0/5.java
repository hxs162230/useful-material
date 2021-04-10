5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

T:O(N*N)
S:O(1)

class Solution {
        int start=0;
        int end=0;
        int max=0;
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        for(int i=0;i<s.length()-1;i++){
            palin(i,i,s);
            palin(i,i+1,s);
        }
        return s.substring(start,end+1);
    }
    public void palin(int pre,int next,String s){
        while(pre>=0&&next<s.length()&&s.charAt(pre)==s.charAt(next)){
            pre--;
            next++;
        }
        if(next-pre-1>max){
            start = pre+1;
            end = next-1;
            max=next-pre-1;
        }
    }
}