class Solution {
    public int climbStairs(int n) {
        //DP
        //dp[i]=dp[i-1]+dp[i-2];
        int first=1;
        int second=1;
        int tmp=0;
        
        for(int i=2;i<n+1;i++){
            tmp=second;
            second=first+second;
            first=tmp;
        }
        return second;
    }
}