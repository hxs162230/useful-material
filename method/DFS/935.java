935. Knight Dialer

A chess knight can move as indicated in the chess diagram below:

 .           

This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

Optimization:
Observe the recursive problem. The variances are:

Current Node
Remain Steps
Therefore, we can store these two variables as the memo to speed up DFS (then it's a Top Down DP)

1 2 3
4 5 6
7 8 9
  0
class Solution {
    int mod = 1000000007;
    int[][] pos = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    int[][] dp;
    public int knightDialer(int N) {
        int res = 0;
        dp = new int[10][N+1];
        for(int i=0;i<=9;i++){
            res+=dfs(i,N);
            res%=mod;
        }
        return res;
    }
    public int dfs(int st,int N){
        if(N==1) return 1;
        if(dp[st][N]>0) return dp[st][N];
        int cnt=0;
        for(int nextJp:pos[st]){
            cnt+=dfs(nextJp,N-1);
            cnt%=mod;
        }
        dp[st][N] = cnt;
        return dp[st][N];
    }
}