22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

T:O(2^2n)
S:O(n)
if n=3
(
((
(((
((()
((())
((()))
(()
(()(
(()()
(()())
...



class Solution {
    List<String> lst = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        int left=0;
        int right=0;
        dfs("",n,left,right);
        return lst;
    }
    public void dfs(String s,int n,int left,int right){
        if(s.length()==n*2){
            lst.add(s);
            return;
        }
        if(left<n) dfs(s+"(",n,left+1,right);
        if(right<left) dfs(s+")",n,left,right+1);
    }
}