1066. Campus Bikes II
Medium

243

18

Favorite

Share
On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.

We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.

 

Example 1:



Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: 6
Explanation: 
We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.
Example 2:



Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: 4
Explanation: 
We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1. Both assignments lead to sum of the Manhattan distances as 4.
 

Note:

0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
All worker and bike locations are distinct.
1 <= workers.length <= bikes.length <= 10

permutation problems

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[][] dp = new int[workers.length][1<<bikes.length];
        return dfs(workers,bikes,0,dp,0);   
    }
    public int dfs(int[][] w,int[][] b,int i,int[][] dp,int mask){
        if(i==w.length) return 0;
        if(dp[i][mask]>0) return dp[i][mask];
        int min = Integer.MAX_VALUE;    
        for(int j=0;j<b.length;j++){
            if((mask&(1<<j))!=0) continue;                                               => 不可用==1
            int dis = Math.abs(w[i][0]-b[j][0])+Math.abs(w[i][1]-b[j][1]);
            min = Math.min(min,dis+dfs(w,b,i+1,dp,mask|1<<j));
        }
        dp[i][mask] = min;
        return min;
    }
    
}

class Solution {
    int min=Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visit = new boolean[bikes.length];
        dfs(workers,bikes,0,0,visit);
        return min;
    }
    public void dfs(int[][] w,int[][] b,int x,int dis,boolean[] visit){
        if(x==w.length){
            min = Math.min(dis,min);
            return;
        }
        if(dis>min) return;
        for(int j=0;j<b.length;j++){
            if(visit[j]) continue;
            visit[j]=true;
            int d = Math.abs(w[x][0]-b[j][0])+Math.abs(w[x][1]-b[j][1]);
            dfs(w,b,x+1,d+dis,visit);
            visit[j]=false;
        }
    }
}