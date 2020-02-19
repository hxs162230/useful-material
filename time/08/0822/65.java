65. Valid Number
Hard

530

3798

Favorite

Share
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.

class Solution {
    public boolean isNumber(String s) {
        int i=0;
        while(i<s.length()&&(s.charAt(i)==' ')){
             i++;
        }
        if(i==s.length()) return false;
        if(s.charAt(i)=='+'||s.charAt(i)=='-') 
            i++;
        int numOfpoint=0;
        int numOfdigit=0;
        for(;i<s.length()&&(s.charAt(i)=='.'||Character.isDigit(s.charAt(i)));i++){
            if(s.charAt(i)=='.') numOfpoint++;
            else numOfdigit++;
         }
        if(numOfpoint>1||numOfdigit<1) return false;
        
        if(i<s.length()&& s.charAt(i)=='e'){
            i++;
            if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-')) i++;
            for(numOfdigit=0;i<s.length()&&(Character.isDigit(s.charAt(i)));i++){
                numOfdigit++;
            }
            if(numOfdigit<1) return false;
        }
        while(i<s.length()&&s.charAt(i)==' ') i++;
        return i==s.length();
    }
}

class Solution {
    public boolean isNumber(String s) {
        if(s.length()<=0) return false;
        boolean Num =false;
        boolean E=false;
        boolean numAfterE=true;
        boolean sign=false;
        boolean Dot=false;
        for(int i=0;i<s.length();i++){
         if(s.charAt(i)==' '){
             if(i+1<s.length() && s.charAt(i+1)!=' ')
                if(Num||E||sign||Dot)
                    return false;
         }
        else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
            if(i>0 &&s.charAt(i-1)!=' '&&s.charAt(i-1)!='e') return false;
            sign=true;
        }
        else if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
            Num=true;
            numAfterE=true;
        }
        else if(s.charAt(i)=='.'){
            if(Dot||E) return false;
            Dot=true;
        }
        else if(s.charAt(i)=='e'){
            if(E||!Num) return false;
            numAfterE=false;
            E=true;
        }
        else 
            return false;
        }
        return Num&&numAfterE;
    }
}
// 所有的字符可以分为六大类，空格，符号，数字，小数点，自然底数和其他字符，我们需要五个标志变量，num, dot, exp, sign分别表示数字，小数点，自然底数和符号是否出现，numAfterE表示自然底数后面是否有数字，那么我们分别来看各种情况：

// - 空格： 我们需要排除的情况是，当前位置是空格而后面一位不为空格，但是之前有数字，小数点，自然底数或者符号出现时返回false。

// - 符号：符号前面如果有字符的话必须是空格或者是自然底数，标记sign为true。

// - 数字：标记num和numAfterE为true。

// - 小数点：如果之前出现过小数点或者自然底数，返回false，否则标记dot为true。

// - 自然底数：如果之前出现过自然底数或者之前从未出现过数字，返回false，否则标记exp为true，numAfterE为false。

// - 其他字符：返回false。

// 最后返回num && numAfterE即可。
bool isNumber(const char *s) 
{
    int i = 0;

    // skip the whilespaces
    for(; s[i] == ' '; i++) {}

    // check the significand
    if(s[i] == '+' || s[i] == '-') i++; // skip the sign if exist

    int n_nm, n_pt;
    for(n_nm=0, n_pt=0; (s[i]<='9' && s[i]>='0') || s[i]=='.'; i++)
        s[i] == '.' ? n_pt++:n_nm++;       
    if(n_pt>1 || n_nm<1) // no more than one point, at least one digit
        return false;

    // check the exponent if exist
    if(s[i] == 'e') {
        i++;
        if(s[i] == '+' || s[i] == '-') i++; // skip the sign

        int n_nm = 0;
        for(; s[i]>='0' && s[i]<='9'; i++, n_nm++) {}
        if(n_nm<1)
            return false;
    }

    // skip the trailing whitespaces
    for(; s[i] == ' '; i++) {}

    return s[i]==0;  // must reach the ending 0 of the string
}