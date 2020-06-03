1209. Remove All Adjacent Duplicates in String II
Medium

420

14

Add to List

Share
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.



class Solution {
    class Node{
        char c;
        int continueCnt;
        public Node(char c){
            this.c = c;
            this.continueCnt = 1;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty()&&stk.peek().c==s.charAt(i)){
                stk.peek().continueCnt++;
            }
            else{
                stk.push(new Node(s.charAt(i)));
            }
            if(!stk.isEmpty()&&stk.peek().continueCnt==k){
                stk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Node e:stk){
            for(int i=0;i<e.continueCnt;i++)
                sb.append(e.c);
        }
        return sb.toString();
    }

}