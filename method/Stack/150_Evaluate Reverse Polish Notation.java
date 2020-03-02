150. Evaluate Reverse Polish Notation
Medium

675

394

Favorite

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
T:O(N)
S:O(N)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token:tokens){
            if(!token.equals("+")&&!token.equals("-")&&!token.equals("*")&&!token.equals("/")){
                //System.out.print(token);
                stk.push(Integer.parseInt(token));
                
            }
            else{
                int num2 = stk.pop();
                int num1 = stk.pop();
               if(token.equals("+")) 
                    stk.push(num1+num2);
               else if(token.equals("*"))
                    stk.push(num1*num2);
               else if(token.equals("-"))
                    stk.push(num1-num2);
               else
                    stk.push(num1/num2);
                
            }
        }
        return stk.peek();
    }
}