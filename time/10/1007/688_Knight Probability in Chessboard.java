688. Knight Probability in Chessboard


On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

 



 

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

 

Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
 

Note:

N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.


class Solution {
    int[][] dirs={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    double[][][] cache;
    public double knightProbability(int N, int K, int r, int c) {
        cache = new double[K+1][N][N];
        return dfs(N,K,r,c)/Math.pow(8,K);
    }
    public double dfs(int N,int k,int r,int c){
        if(k==0) return 1.0;
        if(cache[k][r][c]!=0.0) return cache[k][r][c]; 
        double res=0;
        for(int[] dir:dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            if(x<0||y<0||x>=N||y>=N) continue;
            res+= dfs(N,k-1,x,y);
            
        }
        cache[k][r][c] = res;
        return cache[k][r][c];
    }
}