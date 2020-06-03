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



BBC_ABCDAB_ABCDABCDABDE
    ABCDABD
此时KMP算法并不是将模式串向右移动一位，而是向后移动四位，直接到这一步：

BBC_ABCDAB_ABCDABCDABDE
        ABCDABD
这样文本串的遍历位置并不会移回去，而是'_'直接跟'C'匹配，是不是很神奇，它怎么知道要跟模式串上的哪个字符相比呢，实际上是从next数组中查的值，再讲解next数组之前，我们先来讲一下最大前缀后缀公共元素。

所谓最大前缀后缀公共元素，就是模式串中最大且相等的前缀和后缀，比如aba，有长度为1的相同前缀后缀a，再比如，字符串acdac有长度为2的相同前缀后缀ac，那么我们可以写出ABCDABD的每一位上的前缀后缀长度：

A   B   C   D   A   B   D
0   0   0   0   1   2   0
由于模式串的尾部可能有重复的字符，所以我们可以得出一个重要的结论：


失配时，模式串向右移动的距离 = 已匹配字符数 - 失配字符的上一位字符所对应的最大长度值


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



