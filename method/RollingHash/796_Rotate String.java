796. Rotate String
Easy

665

50

Add to List

Share
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.


class Solution {
    public boolean rotateString(String A, String B) {
        String s = A+A;
        if(A.length()!=B.length()) return false;
        long mod = (long)Math.pow(2,32);
        int[] cnt = new int[s.length()];
        for(int i=0;i<s.length();i++){
            cnt[i] = s.charAt(i)-'a';
        }
        
        long b_hashnum = 0;
        for(int i=0;i<B.length();i++){
            b_hashnum = b_hashnum*26+(B.charAt(i)-'a');
            b_hashnum%=mod;
        }
        
        long a_hashnum = 0;
        for(int i=0;i<A.length();i++){
            a_hashnum = a_hashnum*26+(A.charAt(i)-'a');
            a_hashnum %= mod;
        }
        
        if(a_hashnum==b_hashnum) return true;
        
        long f = 1;
        for(int a=1;a<=A.length();a++){
            f*=26;
            f%=mod;
        }
        
        for(int i=1;i<=s.length()-A.length();i++){
            a_hashnum =(a_hashnum*26-cnt[i-1]*f%mod+mod)%mod;
            a_hashnum=(a_hashnum+cnt[i+A.length()-1])%mod;
            if(a_hashnum==b_hashnum) return true;
        }
        return false;
    }
}