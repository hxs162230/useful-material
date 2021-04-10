342. Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?

T:O(1)
S:O(1)

class Solution {
    public boolean isPowerOfFour(int num) {
        return ((int)(Math.log(num) / Math.log(4))-(Math.log(num) / Math.log(4))==0?true:false);
    }
}