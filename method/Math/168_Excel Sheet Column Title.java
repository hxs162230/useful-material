168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
29 AC
29-1 = 28;
28%26 = 2;  =>C;
28/26 = 1;
loop... 

Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"


class Solution {
    public String convertToTitle(int n) {
        if(n<=0) return "";
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            n--;
            int val = (n)%26;
            sb.append((char)('A'+val));
            //n=n-val;
            n/=26;
        }
        return sb.reverse().toString();
    }
}