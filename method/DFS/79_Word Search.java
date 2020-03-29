79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

T:O(MN*4^length)
S:O(MN)


class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0) return false;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(i,j,visit,board,word,0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,boolean[][] visit,char[][] board,String word,int idx){
        if(idx==word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx)||visit[i][j]) return false;
        if(!visit[i][j]) 
            visit[i][j]=true;
        boolean res = dfs(i+1,j,visit,board,word,idx+1)||
                      dfs(i-1,j,visit,board,word,idx+1)||
                      dfs(i,j+1,visit,board,word,idx+1)||
                      dfs(i,j-1,visit,board,word,idx+1);
        visit[i][j]=false;
        return res;
    }
}