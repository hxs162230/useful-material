1335. Minimum Difficulty of a Job Schedule
Hard

312

18

Add to List

Share
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

 

Example 1:


Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7 
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.
Example 4:

Input: jobDifficulty = [7,1,7,1,7,1], d = 3
Output: 15
Example 5:

Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
Output: 843
 

Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10


class Solution {
    int[][] cache;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length; 
        if(len<d) return -1;
        this.cache = new int[d+1][len];
        for(int[] c:cache) Arrays.fill(c,-1);
        return dfs(jobDifficulty,d,0);
    }
    public int dfs(int[] J,int d,int st){
        if(d==0||st>=J.length) return 0;
        if(d==1){
            return rst(J,st);
        }
        if(cache[d][st]!=-1) return cache[d][st];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=st;i<J.length-d+1;i++){
            max = Math.max(max,J[i]);
            min = Math.min(min,max+dfs(J,d-1,i+1));
        }
        cache[d][st] = min;
        return min;
    }
    public int rst(int[] J,int st){
        int res = 0;
        for(int i=st;i<J.length;i++){
            res = Math.max(res,J[i]);
        }
        return res;
    }
    
}


class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length; 
        if(len<d) return -1;
        int[] dp = new int[len];
        dp[len-1] = jobDifficulty[len-1];
        for(int i=len-2;i>=0;i--){
            dp[i] = Math.max(dp[i+1],jobDifficulty[i]);
        }
        for(int D=2;D<=d;D++){
            for(int i=0;i<len-D+1;i++){
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(int j=i;j<len-D+1;j++){
                    max = Math.max(max,jobDifficulty[j]);
                    min = Math.min(min,max+dp[j+1]);
                }
                dp[i] = min;
            }
        }
        return dp[0];
    }
}