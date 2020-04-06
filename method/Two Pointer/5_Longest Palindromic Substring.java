5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. 

You may assume that the maximum length of s is 1000.

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

manacher O(N)
class Solution {
    public String longestPalindrome(String s) {
        char[] c = process(s);
        int C=0;
        int R=0;
        int[] P = new int[c.length];
        for(int i=1;i<c.length-1;i++){
            int i_mirror = 2*C-i;
            if(R>i){
                P[i] = Math.min(R-i,P[i_mirror]);
            }
            else{
                P[i] = 0;
            }
            while(c[i-1-P[i]]==c[i+1+P[i]]){
                P[i]++;
            }
            if(i+P[i]>R){
                R = i+P[i];
                C = i;
            }
        }
        int maxR = 0;
        int center = 0;
        for(int i=1;i<c.length-1;i++){
            if(P[i]>maxR){
                maxR = P[i];
                center = i;
            }
        }
        int start = (center-maxR)/2;
        
        return s.substring(start,start+maxR);
    }
    
    public char[] process(String s){
        char[] schar = new char[2*s.length()+1+2];
        schar[0] = '^';
        int idx=1;
        for(int i=0;i<s.length();i++){
            schar[idx++] = '#';
            schar[idx++] = s.charAt(i);
        }
        schar[idx++] = '#';
        schar[idx++] = '%';
        return schar;
    }
    
}