1416. Restore The Array
Hard

206

5

Add to List

Share
A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.

Given the string s and the integer k. There can be multiple ways to restore the array.

Return the number of possible array that can be printed as a string s using the mentioned program.

The number of ways could be very large so return it modulo 10^9 + 7

 

Example 1:

Input: s = "1000", k = 10000
Output: 1
Explanation: The only possible array is [1000]
Example 2:

Input: s = "1000", k = 10
Output: 0
Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
Example 3:

Input: s = "1317", k = 2000
Output: 8
Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
Example 4:

Input: s = "2020", k = 30
Output: 1
Explanation: The only possible array is [20,20]. [2020] is invalid because 2020 > 30. [2,020] is ivalid because 020 contains leading zeros.
Example 5:

Input: s = "1234567890", k = 90
Output: 34
 

Constraints:

1 <= s.length <= 10^5.
s consists of only digits and doesn't contain leading zeros.
1 <= k <= 10^9.


class Solution {
    int mod = (int)Math.pow(10,9)+7;
    int[] dp;
    public int numberOfArrays(String s, int k) {
        this.dp = new int[s.length()];
        return dfs(s,k,0);
    }
    
    public int dfs(String s,long k,int st){
        if(st>=s.length()) return 1;
        if(s.charAt(st)=='0') return 0;
        
        if(dp[st]!=0) return dp[st];
        
        int ans = 0;
        long num = 0;
        for(int i=st;i<s.length();i++){
            num = num*10+(s.charAt(i)-'0');
            if(num>k) break;
            ans+=dfs(s,k,i+1);
            ans%=mod;
            
        }
        
        dp[st] = ans;
        return ans;
    }
    

    
}