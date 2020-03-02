946. Validate Stack Sequences

Given two sequences pushed and popped with distinct values, 

return true 

if and only if this could have been the result of a 

sequence of push and pop operations 

on an initially empty stack.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 

Note:

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values.

T:O(N)
S:O(N)

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk =new Stack<>();
        int pushLen = pushed.length;
        int popLen = popped.length;
        int j=0;
        for(int i=0;i<pushLen;i++){
                 stk.push(pushed[i]);
            while(!stk.isEmpty() &&stk.peek()==popped[j]){
                j++;
                stk.pop();
            }
            
          
            
        }
        return stk.isEmpty();
    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stk.push(pushed[i]);
            while(!stk.isEmpty()&&stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
        }
        return j==popped.length;
    }
}