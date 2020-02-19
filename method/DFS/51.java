51. N-Queens
Hard

1233

57

Favorite

Share
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] qn = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                qn[i][j]='.';
        }
        dfs(res,qn,0);
        return res;
    }
    public void dfs(List<List<String>> res,char[][] qn,int curRow){
        if(curRow==qn.length){
            ArrayList<String> lst = new ArrayList<>();
            for(int row=0;row<qn.length;row++){
                lst.add(String.valueOf(qn[row]));
            }
            res.add(new ArrayList<>(lst));
            return ;
        }
        for(int i=0;i<qn.length;i++){
            if(isValid(qn,curRow,i)){
                qn[curRow][i]='Q';
                dfs(res,qn,curRow+1);
                qn[curRow][i]='.';
            }
        }
    }
    public boolean isValid(char[][] qn,int curRow,int curCol){
        for(int i=0;i<curRow;i++){
            if(qn[i][curCol]=='Q') return false;
        }
        for(int i=curRow-1,j=curCol-1;i>=0 && j>=0;i--,j--){
            if(qn[i][j]=='Q') return false;
        }
        for(int i=curRow-1,j=curCol+1;i>=0 && j<qn.length;i--,j++){
            if(qn[i][j]=='Q') return false;
        }
        return true;
    }
}