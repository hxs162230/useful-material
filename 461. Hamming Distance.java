461. Hamming Distance
Easy

2903

196

Add to List

Share
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1



class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int cnt = 0;
        while(xor>0){
            cnt+=xor&1;
            xor>>=1;
        }
        return cnt;
    }
}
