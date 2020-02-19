174. Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)  -3  3
-5  -10 1
10  30  -5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.


T:O(MN)
S:O(MN)

dp[][] means minimum start health point maintain
starting form dp[m][n-1] and dp[m-1][n] and its hp=1 (which is minimum)
reverse route 
when encounter dungeon[][]>0 => - if Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j] < 1 =>dp[][]=1
     encounter dungeon[][]<0 => + need atleast this amount of hp
return dp[0][0] 

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        for(int[] di:dp) Arrays.fill(di,Integer.MAX_VALUE);
        dp[dungeon.length][dungeon[0].length-1]=1;
        dp[dungeon.length-1][dungeon[0].length]=1;
        
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                dp[i][j] = Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);        
            }
        }
        return dp[0][0];
    }
}