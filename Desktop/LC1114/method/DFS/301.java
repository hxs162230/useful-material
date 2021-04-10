301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. 

Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]


T:O(2^(left+right))



class Solution {
    List<String> lst = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                left++;
            if(left==0){
                if(s.charAt(i)==')')
                    right++;
            }
            else{
                if(s.charAt(i)==')')
                    left--;
            }
        }
        dfs(s,left,right,0);
        return lst;
    }
    public void dfs(String s,int l,int r,int start){
        if(l==0&&r==0){
            if(isValid(s)){
                lst.add(s);
                return;
            }
        }
        for(int i=start;i<s.length();i++){
            if(i!=start&&s.charAt(i)==s.charAt(i-1)) continue;
            if(s.charAt(i)=='('||s.charAt(i)==')'){
                if(l>0){
                    dfs(s.substring(0,i)+s.substring(i+1),l-1,r,i);
                }
                else if(r>0){
                    dfs(s.substring(0,i)+s.substring(i+1),l,r-1,i);
                }
            }
        }
    }
    public boolean isValid(String s){
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cnt++;
            }
            else if(s.charAt(i)==')'){
                cnt--;
            }
            if(cnt<0)
                return false;
        }
        return cnt==0;
    }
}