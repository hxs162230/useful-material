647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings 

in this string.

The substrings with different start indexes or end indexes are counted as different 

substrings even they consist of same characters.

class Solution {
    int res=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        return res;
    }
    public void isPalindrome(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
          
                i--;
                j++;
                res++;
            
        }
    }
}