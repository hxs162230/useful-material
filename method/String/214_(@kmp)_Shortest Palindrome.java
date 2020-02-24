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











