212. Word Search II
Hard

1512

82

Favorite

Share
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 

The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.

T:O(M^2*N^2)
S:O(M+N)

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Tnode root = builtTire(words);
        List<String> lst =new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                recur(board,i,j,root,lst);
            }
        }
        return lst;
        
        
    }
    public void recur(char[][] board,int v,int h,Tnode root,List<String> lst){
        char c = board[v][h];
        int m=board.length;
        int n=board[0].length;
        if(board[v][h]=='#'||root.children[c-'a']==null) return;
        root=root.children[c-'a'];
        if(root.item!=""){
            lst.add(root.item);
            root.item="";
        }
        
        board[v][h]='#';
        if(v+1<m)
            recur(board,v+1,h,root,lst);
        if(v-1>=0)
            recur(board,v-1,h,root,lst);
        if(h+1<n)
            recur(board,v,h+1,root,lst);
        if(h-1>=0)
            recur(board,v,h-1,root,lst);
         board[v][h]=c;
    
    }
    public Tnode builtTire(String[] words){       
        Tnode root =new Tnode();
        for(String a:words){
            Tnode cur=root; 
            for(int i=0;i<a.length();i++){
                if(cur.children[a.charAt(i)-'a']==null)
                    cur.children[a.charAt(i)-'a']=new Tnode();
                cur=cur.children[a.charAt(i)-'a'];
            }   
            cur.item=a;
        }
        return root;
    }
}

class Tnode{
    Tnode[] children;
    String item;
    public Tnode(){
        children=new Tnode[26];
        item="";
    }
}
