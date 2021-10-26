29. Divide Two Integers
Medium

832

4003

Favorite

Share
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==-1&&dividend==Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if(dividend==0) return 0;
        boolean sign = ((dividend>0)^(divisor>0))?false:true;
        long div1 = dividend;
        div1 = Math.abs(div1);
        long div2 = divisor;
        div2 = Math.abs(div2);
        if(divisor==1){
            if(sign)
            return (int)div1;
            else 
            return (int)-div1;
        }
        long val=0;
        while(div1>=div2){
            long k=1;
            long d = div2;
            while(div1>=(d<<1)){
                d<<=1;
                k<<=1;
            }
            val+=k;
            div1-=d;
        }
        if(sign) return (int)val;
        else return (int)-val;
    }
}