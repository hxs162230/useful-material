58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

T:O(N)
S:O(1)

class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int len=s.length();
        int c=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==' '){
                return c;
            }
            else
                c++;
        }
        return c;
    }
}