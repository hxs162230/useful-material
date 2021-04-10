201. Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

T:O(1)
S:O(1)
我们只要写代码找到左边公共的部分即可

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while(m!=n){
            m>>=1;
            n>>=1;
            cnt++;
        }
        return m<<cnt;
    }
}