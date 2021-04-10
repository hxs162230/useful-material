224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

T:O(N)
S:O(N)
遇到 ( =>入STACK
遇到 ) =>出STACK 與現有值做運算
遇到 + OR - =>變更SIGN
遇到 digts =>String to int number

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk  = new Stack<>();
        int sign =1;
        int n=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stk.push(n);
                stk.push(sign);
                n=0;
                sign=1;    
            }
            else if(c==')'){
                int presign = stk.pop();
                int presum = stk.pop();
                n = presign*n + presum;
            }
            else if(c=='+')
                sign = 1;
            else if(c=='-')
                sign = -1;
            else if(c>='0'){
                int num=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    int base = s.charAt(i)-'0';
                    num = num*10+base;
                    i++;
                }
                n+=sign*num;
                i--;
            }
        }
        return n;
    }
}