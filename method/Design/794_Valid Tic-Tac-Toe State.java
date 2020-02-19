794. Valid Tic-Tac-Toe State

A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player always places "X" characters, while the second player always places "O" characters.
"X" and "O" characters are always placed into empty squares, never filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Example 1:
Input: board = ["O  ", "   ", "   "]
Output: false
Explanation: The first player always plays "X".

Example 2:
Input: board = ["XOX", " X ", "   "]
Output: false
Explanation: Players take turns making moves.

Example 3:
Input: board = ["XXX", "   ", "OOO"]
Output: false

Example 4:
Input: board = ["XOX", "O O", "XOX"]
Output: true
Note:

board is a length-3 array of strings, where each string board[i] has length 3.
Each board[i][j] is a character in the set {" ", "X", "O"}.

class Solution {
    public boolean validTicTacToe(String[] board) {
        int turn =0;
        int[] row = new int[3];
        int[] col = new int[3];
        boolean xWin  = false;
        boolean oWin = false;
        int dig=0,rev=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='X'){
                    turn++;
                    row[i]++;
                    col[j]++;
                    if(i==j)
                        dig++;
                    if(i+j==2)
                        rev++;
                }
                else if(board[i].charAt(j)=='O'){
                    turn--;
                    row[i]--;
                    col[j]--;
                    if(i==j)
                        dig--;
                    if(i+j==2)
                        rev--;
                }
            }
        }
        if(row[0]==3||row[1]==3||row[2]==3||col[0]==3||col[1]==3||col[2]==3||dig==3||rev==3)
            xWin = true;
        if(row[0]==-3||row[1]==-3||row[2]==-3||col[0]==-3||col[1]==-3||col[2]==-3||dig==-3||rev==-3)
            oWin = true;
        
        if((turn==0&&xWin)||(turn==1&&oWin)) return false;
        
        return (turn==0||turn==1)&&(!xWin||!oWin);
        
        
        
    }
}