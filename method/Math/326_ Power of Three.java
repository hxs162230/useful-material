326. Power of Three

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?

T:O(logN)  O(1)
S:O(1)
   
class Solution {
    public boolean isPowerOfThree(int n) {
        int num=1;
        while(num<Integer.MAX_VALUE/3){     avoiding overflow
            num*=3;
        }
        if(n>0&&num%n==0) return true;
        else return false;
    }
}
