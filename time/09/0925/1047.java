1047. Remove All Adjacent Duplicates In String

Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<S.length()){
            if(!stk.isEmpty()&&S.charAt(i)==stk.peek()){
                stk.pop();
                i++;
            }
            else{
                stk.push(S.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:stk) sb.append(c);
        return sb.toString();
    }
}