856. Score of Parentheses
Medium

1592

51

Add to List

Share
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 

Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50


class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stk = new Stack<>();
        int len = S.length();
        int cur =0;
        for(int i=0;i<len;i++){
            if(S.charAt(i)=='('){
                stk.push(cur);
                cur = 0;
            }
            else{
                    //previous sum + (max of cursum)
                cur = stk.pop()+Math.max(2*cur,1);
            }
        }
        return cur;
        
        /*
        think of the case ()() and (())
                          1+1      0+max(2*1,1)         
        
        */
        
    }
}