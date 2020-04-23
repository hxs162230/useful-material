1197. Minimum Knight Moves
Medium

173

65

Add to List

Share
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

 

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 

Constraints:

|x| + |y| <= 300

sol1
time:log(V+E)
class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dir = {{2,1},{-2,1},{-2,-1},{2,-1},{1,2},{1,-2},{-1,-2},{-1,2}};
        int step = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visit = new HashSet<>();
        int[] st = {0,0};
        q.add(st);
        visit.add("0,0");
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] val = q.poll();
                int curX = val[0];
                int curY = val[1];
                if(curX==x&&curY==y) return step;
                for(int[] d:dir){
                    int nX = curX+d[0];
                    int nY = curY+d[1];
                    int[] n = {nX,nY};
                    String ns = String.valueOf(nX)+","+String.valueOf(nY);
                    if(nX==x&&nY==y) return step+1;
                    if(visit.contains(ns)||nX<-1||nY<-1) continue;
                    visit.add(ns);
                    q.add(n);
                }
            }
            step++;
        }
        return -1;
    }
}


class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dir = {{2,1},{-2,1},{-2,-1},{2,-1},{1,2},{1,-2},{-1,-2},{-1,2}};
        int step = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visit = new HashSet<>();
        
        q.add(0);
        visit.add(0);
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int val = q.poll();
                int curX = val/1000;
                int curY = val%1000;
                if(curX==x&&curY==y) return step;
                for(int[] d:dir){
                    int nX = curX+d[0];
                    int nY = curY+d[1];
                    int ns = nX*1000+nY;
                    if(nX==x&&nY==y) return step+1;
                    if(visit.contains(ns)||nX<-1||nY<-1) continue;
                    visit.add(ns);
                    q.add(ns);
                }
            }
            step++;
        }
        return -1;
    }
}

hashCode可改為String pair (time complexity increase)

class Solution {
    HashMap<Integer,Integer> cache;
    public int minKnightMoves(int x, int y) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        cache = new HashMap<>();
        return dfs(a,b);
    }
    public int dfs(int a,int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(a==0&&b==0) return 0;
        if(a==1&&b==1) return 2;
        if(a==0&&b==2) return 2;
        if(a==2&&b==0) return 2;
        int hashCode = a*1000+b;
        if(cache.containsKey(hashCode)) return cache.get(hashCode); 
        int ans = Math.min(dfs(a-2,b-1),dfs(a-1,b-2))+1;
        cache.put(hashCode,ans);
        return ans;
    }
}