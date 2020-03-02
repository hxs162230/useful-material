829. Consecutive Numbers Sum
Hard

209

313

Favorite

Share
Given a positive integer N, how many ways can we write it 

as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.


        //(x+x+(m-1))m/2 = mx + (m-1)*m/2
        //x首項

class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans=0;
        for(int m=1;;m++){
            int mx = N - m*(m-1)/2;
            if(mx<=0) break; //x首項 不含0 ex:012345
            if(mx%m==0) ans++;
        }
        return ans;
    }
}