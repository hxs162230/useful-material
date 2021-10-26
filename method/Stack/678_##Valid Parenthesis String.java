678. Valid Parenthesis String
Medium

1834

51

Add to List

Share
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].


class Solution {
    public boolean checkValidString(String s) {
        if(s==null||s.length()==0) return true;
        int left1 = 0;
        int left2 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left1++;
                left2++;
            }
            else if(s.charAt(i)==')'){
                left1--;
                left2--;
            }
            else if(s.charAt(i)=='*'){
                left1++;
                left2--;
            }
            
            if(left1<0) return false;
            
            left2 = Math.max(0,left2);
        }
        return left2==0;
    }
}