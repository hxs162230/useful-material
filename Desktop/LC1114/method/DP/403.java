403. Frog Jump

A frog is crossing a river. The river is divided into x units and at each 

unit there may or may not exist a stone. The frog can jump on a stone, 

but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, 

determine if the frog is able to cross the river by landing on the last stone. 

Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 

Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.


ndex:        0   1   2   3   4   5   6   7 
            +---+---+---+---+---+---+---+---+
stone pos:  | 0 | 1 | 3 | 5 | 6 | 8 | 12| 17|
            +---+---+---+---+---+---+---+---+
k:        0 | 0 | 1 | 0 | 0 | 1 | 0 | 0 | 0 |
          1 | 1 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
          2 | 0 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
          3 | 0 | 0 | 1 | 1 | 1 | 1 | 1 | 0 |
          4 | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 0 |
          5 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 1 |
          6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
          7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |

// Sub-problem and state:
let dp[i][j] denote at stone i, the frog can or cannot make jump of size j


class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(len==2){
            return (stones[1]-stones[0])==1;
        }
        
        boolean[][] dp= new boolean[len][len+1];
        dp[0][1]=true;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                int diff = stones[i]-stones[j];
                if(diff<0 ||diff>len||!dp[j][diff]) continue;
                dp[i][diff]=true;
                if(diff-1>0) dp[i][diff-1]=true;
                if(diff+1<=len) dp[i][diff+1]=true;
                if(i==len-1) return true; 
            }
        }
        return false;
    }
}