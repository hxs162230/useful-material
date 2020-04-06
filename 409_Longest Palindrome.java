409. Longest Palindrome
Easy

802

77

Add to List

Share
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)]++;
        }
        int odd = 0;
        for(int i=0;i<128;i++){
            if(map[i]%2==1) odd++;
        }
		// can only tolerate one char with odd numbers        
        return odd==0?s.length():s.length()-odd+1;
    }
}


