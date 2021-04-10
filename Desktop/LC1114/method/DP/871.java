871. Minimum Number of Refueling Stops

A car travels from a starting position to a destination 

which is target miles east of the starting position.

Along the way, there are gas stations.  Each station[i] represents a gas station 

that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  

It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station, it may stop and refuel, 

transferring all the gas from the station into the car.

What is the least number of refueling stops the car must make in order to reach its destination?  

If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  

If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can't reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: 
We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.
 

Note:

1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target


01背包問題
这是最基础的背包问题，特点是：每种物品只有一件，可以选择放或者不放

用子问题定义状态：即dp[i][j]表示前i件物品放入一个容量为j的背包可以获得的最大价值。则其状态转移方程为：

dp[i][j] = max{dp[i - 1][j], dp[i - 1][j - c[i]] + w[i]}

这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生出来。这里详细解释一下：

将前i件物品放入容量为j的背包中这个子问题，若只考虑第i件物品的策略（放或者不放），那么就可以转换为一个只牵扯前i-1件物品的问题。
如果不放第i件物品，那么问题就转换为前i-1件物品放入容量为j的背包中的最大价值，价值为dp[i - 1][j]
如果放入第i件物品，那么问题就转换为前i-1件物品放入容量为j-c[i]的背包中，此时能获得的最大价值是dp[i-1][j-c[i]],再加上放入第i件物品获得的价值w[i]

完全背包问题

题目
有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，价格是w[i].求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大

思路
这个问题类似于01背包问题，所不同的是每种物品有无限件。也就是从每种物品的角度考虑，与它相关的策略已非取或不取两种，而且右取0件、取1件、取2件...等很多种。如果仍然按照01背包的思路，令dp[i][v]表示前i种物品恰好放入一个容量为v的背包的最大权值。仍然可以按照每种物品不同的策略写出状态转移方程：

f[i][v]=max{f[i-1][v],f[i][v-c[i]]+w[i]}



此題為01背包變種

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = startFuel;
        for(int i=1;i<=n;i++){
            if(startFuel>=stations[i-1][0]) 
                dp[i][0] = startFuel;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(dp[i-1][j]>=stations[i-1][0])
                    dp[i][j] = dp[i-1][j];
                if(dp[i-1][j-1]>=stations[i-1][0])
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+stations[i-1][1]);
            }
        }
        for(int j=0;j<=n;j++){
            if(dp[n][j]>=target) return j;
        }
        return -1;
    }
}