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