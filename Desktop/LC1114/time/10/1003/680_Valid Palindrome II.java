680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


class Solution {
    public boolean validPalindrome(String s) {
        int len=s.length();
        int left=0;
        int right=len-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return isValid(left+1,right,s) || isValid(left,right-1,s);
            left++;
            right--;
        }
        return  true;
    }
    public boolean isValid(int left,int right,String s){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        }
        return true;
    }
}