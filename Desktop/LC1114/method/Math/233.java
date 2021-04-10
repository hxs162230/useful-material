233. Number of Digit One

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:

Input: 13
Output: 6 
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.


class Solution {
    public int countDigitOne(int n) {
        if(n<=0) return 0;
        
        int count=0;
        int a=1,b=1;
        while(n>0){
            count+=(n+8)/10*a+ (n%10==1?b:0);//最後一位判定 EX 1432的1
            b+=(n%10)*a;
            a*=10;
            n/=10;            
        }
        return count;
    }
}
/**
 * Calculate occurance on every digit, from
 * least important digit to most important digit
 * number = 1432
 * One's digit: n/10=143 143*1+1
 * Ten's digit: n/100=14 14*10+10
 * Hun's digit: n/1000=1 1*100+100
 * Tho's digit: 1432%1000+1=433
 * Sum all occurance on digits together
 */