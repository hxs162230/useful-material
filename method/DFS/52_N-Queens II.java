52. N-Queens II

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

class Solution {
    
    public int totalNQueens(int n) {
        char[][] qn = new char[n][n];
        for(char[] q:qn) Arrays.fill(q,'.');
        return dfs(0,qn);
    }
    public int dfs(int i,char[][] qn){
        if(i==qn.length){
            return 1;
        }
        int sol=0;
        for(int col=0;col<qn[0].length;col++){
            if(isValid(i,col,qn)){
                qn[i][col] = 'Q';
                sol+=dfs(i+1,qn);
                qn[i][col] = '.';
            }
        }
        return sol;
    }
    public boolean isValid(int i,int j,char[][] qn){
        for(int x=0;x<i;x++){
            if(qn[x][j]=='Q') return false;
        }
        for(int x=i-1,y=j-1;x>=0&&y>=0;x--,y--){
            if(qn[x][y]=='Q') return false;
        }
        for(int x=i-1,y=j+1;x>=0&&y<qn[0].length;x--,y++){
            if(qn[x][y]=='Q') return false;
        }
        return true;
    }
}