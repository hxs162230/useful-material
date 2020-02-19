37. Sudoku Solver
Hard

1171

76

Favorite

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.

class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length!=9||board[0].length!=9) return;
        recur(board,0,0);
    
    }
    public boolean recur(char[][] board,int i,int j){
        //System.out.print("#");
        if(i==9) return true;
        if(j>=9) return recur(board,i+1,0);
        if(board[i][j]=='.'){
            for(int k=1;k<=9;k++){
                board[i][j]=(char)(k+'0');
                //System.out.print("@");
                if(isValid(board,i,j))
                    if(recur(board,i,j+1)) return true; //有解 return true;
                board[i][j]='.'; //無解 回朔
            }
        }
        else{
            return recur(board,i,j+1);
        }
        return false; //i沒到9 返回無解
    }
    
    public boolean isValid(char[][] board, int x,int y){
         //System.out.print("$");
        for(int i=0;i<board.length;i++){
            if(i!=x && board[i][y]==board[x][y])
                return false;
        }
        for(int i=0;i<board[0].length;i++){
            if(i!=y && board[x][i]==board[x][y])
                return false;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((3*(x/3)+i)!=x && (3*(y/3)+j)!=y && board[3*(x/3)+i][3*(y/3)+j]==board[x][y])
                    return false;
            }
        }
        return true;
    }
}