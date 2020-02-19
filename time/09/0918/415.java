Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.


class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int maxLen = Math.max(m,n);
        int[] num = new int[maxLen+1];
        int carry = 0;
        int i=m-1,j=n-1;
        for(;i>=0||j>=0;i--,j--){
            int x = i<0?0:(num1.charAt(i)-'0');
            int y = j<0?0:(num2.charAt(j)-'0');
            num[maxLen--] = (x+y+carry)%10;
            carry = (x+y+carry)/10;
        }
        num[maxLen] = carry;
       
        StringBuilder sb = new StringBuilder();
        for(int n_num:num){
            if(sb.length()!=0||n_num!=0)
                sb.append(n_num);
        }
        return sb.length()==0?"0":sb.toString();
    }
}