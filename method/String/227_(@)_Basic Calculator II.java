227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

T:O(N)
S:O(N)

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        char op = '+';
        int num=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int base = s.charAt(i)-'0';
                num=num*10+base;
            }
            
            if((s.charAt(i)<'0'&&s.charAt(i)!=' ')||i==s.length()-1){
                if(op=='+'){
                    stk.push(num);
                }
                else if(op=='-'){
                    stk.push(-num);
                }
                else if(op=='*'||op=='/'){
                    int tmp =(op=='*'?stk.peek()*num:stk.peek()/num);
                    stk.pop();
                    stk.push(tmp);
                }
                num=0;
                op=s.charAt(i);                     紀錄前一次的OP
            }
        }
        int sum=0;
        while(!stk.isEmpty()) sum+=stk.pop();
        return sum;
    }
}