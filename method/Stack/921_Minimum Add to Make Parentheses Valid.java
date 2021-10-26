921. Minimum Add to Make Parentheses Valid
Medium

704

53

Add to List

Share
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4
 

Note:

S.length <= 1000
S only consists of '(' and ')' characters.


O(N) time 
O(N) space
class Solution {
    public int minAddToMakeValid(String S) {
        if(S==null||S.length()==0) return 0;
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        int res = 0;
        while(i<S.length()){
            if(S.charAt(i)=='('){
                stk.push(i);
            }
            else{
                if(stk.isEmpty()){
                    res++;
                }
                else{
                    stk.pop();
                }
            }
            i++;
        }
        return stk.size()+res;
        
    }
}

O(N)
O(1)
class Solution {
    public int minAddToMakeValid(String S) {
        if(S==null||S.length()==0) return 0;

        int left = 0;
        int right = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                left++;
            }
            else if(S.charAt(i)==')'&&left>0){
                left--;
            }
            else if(S.charAt(i)==')'&&left==0){
                right++;
            }
        }
        return left+right;
    }
}
