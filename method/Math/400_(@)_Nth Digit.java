400. Nth Digit

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

T:O(logN)
S:O(1)
1 ~ 9 include 9 one digit number;
10 ~ 99 include 90 two digits number;
100 ~ 999 include 900 three digits number;
1000 ~ 9999 include 9000 four digits number;
input = 1000000000 potentially overflow case.  cnt = 9^10 will overflow


class Solution {
    public int findNthDigit(int n) {
        long cnt=9;
        int len=1;
        int st=1;
        while(n>cnt*len){
            n-=cnt*len;
            len++;
            st*=10;
            cnt*=10;
        }
                                            n=剩餘DIGITS 個數
        int number = st+(n-1)/len;          找出出現在哪個數字 , why n-1  (start is a number)
        String s = String.valueOf(number);  
        return s.charAt((n-1)%len)-'0';     數字取餘得解
    }
}