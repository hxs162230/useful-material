28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                     if(j==needle.length()-1) return i;
                }
                else
                    break;
            }
        }
        return -1;
    }
}


kmp create LPS
public int strstr(String pat,String txt){
    int[] lps = LPS(pat);
    int i=0;
    int j=0;
    while(i<pat.length()){
        if(pat.charAt(i)==txt.charAt(j)){
            i++;
            j++;
        }
        if(j==M){
            return i-j;
            //j = lps[j-1];
        }
        if(i<pat.length()&&pat.charAt(i)!=txt.charAt(j)){
            if(j!=0){
                j = lps[j-1];
            }
            else{
                i++;
            }
        }

    }

}


public int[] LPS(String pat){
    int len = pat.length();
    int[] lps = new int[len];
    lps[0] = 0;
    int i=1;
    int l = 0;

    while(i<len){
        if(pat.chatAt(i)==pat.charAt(l)){
            lps[i++] = ++l;
        }
        else{
            if(l>0){
                l = lps[l-1];
            }
            else{
                i++;
            }
        }
    }
    return len;
}



