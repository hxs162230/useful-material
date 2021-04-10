10. Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

在if()裡面比較之後進入recursions  
這題的recursion比較複雜

T:O(M*N)
S:O(M+N)
以 p 的Llength做討論 
p.length>1 分4個case做 recursion
當 p[1] = '*' 在s[0]==p[0]||p[0]=='.' 可分為使用*  OR 不使用*


class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if(p.length()==1) return s.length()==1&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if(p.charAt(1)=='*'){
            if(!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'))
                return isMatch(s.substring(1),p)||isMatch(s,p.substring(2));
            else
                return isMatch(s,p.substring(2));
        }
        else{
             if(!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'))
                return isMatch(s.substring(1),p.substring(1));
            else
                return false;
        }
    }
}