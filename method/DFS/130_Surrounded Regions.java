130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1)
                    if(board[i][j]=='O')
                        dfs(i,j,board);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                    if(board[i][j]=='O') board[i][j]='X';
                    else if(board[i][j]=='@') board[i][j]='O';
                       
            }
        }
        
    }
    public void dfs(int i,int j,char[][] b){
        if(i<0||j<0||i>=b.length||j>=b[0].length) return;
        if(b[i][j]!='O') return;
        b[i][j]='@';

        dfs(i+1,j,b);
        dfs(i-1,j,b);
        dfs(i,j+1,b);
        dfs(i,j-1,b);
    }
}