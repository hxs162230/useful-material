214. Shortest Palindrome

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"
虽然不是明显的 KMP 算法，但是也有其的影子在里面。这种 Java 写法也是在找相同的前缀后缀，
但是并没有每次把前缀后缀取出来比较，而是用两个指针分别指向对应的位置比较，
然后用 end 指向相同后缀的起始位置，最后再根据 end 的值来拼接两个字符串。
有意思的是这种方法对应的 C++ 写法会 TLE，跟上面正好相反，那么我们是否能得出 Java 的 substring 操作略慢，
而 C++ 的 reverse 略慢呢，我也仅仅是猜测而已。



class Solution {
    public String shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        int end = j;
        char[] c = s.toCharArray();
        while(i<j){
            if(c[i]==c[j]){
                i++;
                j--;
            }
            else{
                i=0;
                end--;
                j=end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString()+s;
    }
}











KMP算法 O(N)

這題第一個出發點是 從頭開始找 最長的回文子串
如果用naive方法的話 有n個子串 每個要花O(n)時間驗證是不是回文 就O(n^2)了

因為之前讀過KMP算法 知道其中一個核心就是Longest prefix suffix
假如S = ABAXY
那我們生成一個新字串K = ABAXY_XYABA
也就是s + "_" + reversed(s)
那麼K的Longest prefix suffix 就是S的從頭最長的回文串
也就是ABA


int longestPrefixSuffix(string s) {
    int n = s.length();
    int lps[n];
    lps[0] = 0;
    int len = 0;
     
    int i = 1;
    while (i < n) {
        if (s[i] == s[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) len = lps[len-1];
            else {
                lps[i] = 0;
                i++;
            }
        }
    }
    int res = lps[n-1];
    return (res > n/2)? n/2 : res;
}
 
class Solution {
public:
    string shortestPalindrome(string s) {
        if (s.size() == 0) return s;
        string r = s;
        reverse(r.begin(), r.end());
        string t = s + "_" + r;
        int pos = longestPrefixSuffix(t);
        return r.substr(0, s.size()-pos) + s;
    }
};

int longestPrefixSuffix(string s)這個函數是直接從
https://www.geeksforgeeks.org/longest-prefix-also-suffix/
拿下來的