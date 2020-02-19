772. Basic Calculator III
Hard

308

99

Favorite

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 

Note: Do not use the eval built-in library function.

class Solution {
    public int calculate(String s) {
        char op = '+';
        int curSum=0;
        int num=0;
        int res= 0;
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(c>='0'&& c<='9'){
                num = num*10 + c-'0';
            }
            if(c=='('){
            int count = 0;
            int j=i;
            for(;i<s.length();i++){
                if(s.charAt(i)=='(') count++;
                if(s.charAt(i)==')') count--;
                if(count==0) break;
            }
                num = calculate(s.substring(j+1,i));
            }    
            if(c=='+'||c=='-'||c=='*'||c=='/'||i==s.length()-1){
                switch (op) {
                    case '+': curSum += num; break;
                    case '-': curSum -= num; break;
                    case '*': curSum *= num; break;
                    case '/': curSum /= num; break;
                }
                if(c=='+'||c=='-'||i==s.length()-1){
                    res+=curSum;
                    curSum=0;
                }
                op=c;
                num=0;
            }
        }
        return res;
    }
}