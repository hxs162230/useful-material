32. Longest Valid Parentheses
Hard

2797

120

Add to List

Share
Given a string containing just the characters '(' and ')', 

find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

T:O(N)
S:O(N)

class Solution {
    public int longestValidParentheses(String s) {
            Stack<Integer> stk = new Stack<>();
            int st =0;//合法起點
            int max =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                stk.push(i);
            else if(c==')'){
                if(stk.isEmpty()) st = i+1;
                else{
                    stk.pop();
                    max = (stk.isEmpty()? Math.max(i-st+1,max):Math.max(i-stk.peek(),max));
                }                        
        }
        }
         return max;                  
    }
}