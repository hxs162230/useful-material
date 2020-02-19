36. Valid Sudoku
Medium

1104

375

Favorite


Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

=====|=====|=====|
0     1     2

=====|=====|=====|
3     4     5

=====|=====|=====|
6     7     8

=====|=====|=====|

[8][5] ==> 3*2+1 = 7; 
[8][8] ==> 8;
 


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] rowFlag = new boolean[x][9];
        boolean[][] colFlag = new boolean[9][y];
        boolean[][] cellFlag = new boolean[9][9];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]<='9'&&board[i][j]>='0'){
                int c =board[i][j]-'1';
                if(rowFlag[i][c]==true || colFlag[c][j]==true || cellFlag[3*(i/3)+j/3][c] == true)
                    return false;
                rowFlag[i][c] = true;  
                colFlag[c][j] = true; 
                cellFlag[3*(i/3)+j/3][c] = true;
                }
            }
        }
        return true;
    }
}