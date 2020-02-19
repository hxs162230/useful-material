351. Android Unlock Patterns

Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

 

Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.
 


 

Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

class Solution {
    public int numberOfPatterns(int m, int n) {
        boolean[] visit = new boolean[10];
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = 5;
        jump[3][7] = jump[7][3] = 5;
        int res=0;
        res+=dfs(visit,jump,m,n,1,0,0)*4;
        res+=dfs(visit,jump,m,n,4,0,0)*4;
        res+=dfs(visit,jump,m,n,5,0,0);
        return res;
    }
    public int dfs(boolean[] visit,int[][] jump,int m,int n,int cur,int len,int count){
        //int count=0;
        len++;
        if(len>=m) count++;
        if(len>=n) return count;
        visit[cur] = true;
        for(int next=1;next<=9;next++){
            if(visit[next]) continue; //all key must be distinct;
            //visit[next] = true;
            if(jump[cur][next]==0||visit[jump[cur][next]]){
                count=dfs(visit,jump,m,n,next,len,count);
            }
            //visit[next] = false;
        }
        visit[cur] = false;
        return count;
    }
}