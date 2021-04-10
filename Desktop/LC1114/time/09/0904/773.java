773. Sliding Puzzle
Hard

422

15

Favorite

Share
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].


T:O(6*6!) 
Analysis:
There are at most 6! permutation of the 6 numbers: 0~5. For each permustion, cost spaceO(6); String.indexOf() and String.equals() cost time O(6). Therefore, space and time both cost 6 * 6! = 4320.

Time & space: O(4320).

class Solution {
    public int slidingPuzzle(int[][] board) {
        String ans = "123450";
        int[][] ex = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        HashSet<String> visit = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                sb.append(String.valueOf(board[i][j]));
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(sb.toString());
        visit.add(sb.toString());
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                String s = q.poll();
                int idxZero = s.indexOf("0");
                if(s.equals(ans)){
                    return res;
                }
                for(int d: ex[idxZero]){
                    String newstr = s;
                    newstr = swap(newstr,idxZero,d);
                    if(visit.contains(newstr)) continue;
                    visit.add(newstr);
                    q.add(newstr);
                }
            }
            res++;
        }
        return -1;
    }
    public String swap(String s,int i,int j){
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i,s.charAt(j));
        sb.setCharAt(j,s.charAt(i));
        return sb.toString();
    }
}