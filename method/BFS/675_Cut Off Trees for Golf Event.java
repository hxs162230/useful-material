675. Cut Off Trees for Golf Event

You are asked to cut off trees in a forest for a golf event. 

The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, 
and this positive number represents the tree's height.
 

You are asked to cut off all the trees in this forest 

in the order of tree's height - 

always cut off the tree with lowest height first. And after cutting, 

the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. 

If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height 

and there is at least one tree needs to be cut off.

Example 1:

Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
 

Example 2:

Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
 

Example 3:

Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new cmp());
        if(forest.size()==0||forest.get(0).size()==0) return 0;
        int res=0;
        int curPosX=0;
        int curPosY=0;
        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(0).size();j++){
                if(forest.get(i).get(j)>1){
                    pq.add(new int[]{forest.get(i).get(j),i,j});
                }
            }
        }
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int cnt = bfs(curPosX,curPosY,t[1],t[2],forest);
            if(cnt<0) return -1;
            res+=cnt;
            curPosX=t[1];
            curPosY=t[2];
        }
        return res;
    }
    public int bfs(int cx,int cy,int dx,int dy,List<List<Integer>> forest){
        if(cx==dx&&cy==dy) return 0;
        Queue<Integer> q = new LinkedList<>();
        int m = forest.size();
        int n = forest.get(0).size();
        q.add(cx*n+cy);
        int step=0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visit = new boolean[m][n];
        visit[cx][cy] = true;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int t = q.poll();
                int curX = t/n;
                int curY = t%n;
                if(curX==dx&&curY==dy) return step;
                for(int[] dir:dirs){
                    int x=curX+dir[0];
                    int y=curY+dir[1];
                    if(x<0||y<0||x>=m||y>=n||forest.get(x).get(y)==0||visit[x][y]) continue;
                    
                    visit[x][y] = true;
                    q.add(x*n+y);
                }
            }
            step++;
        }
        return -1;
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]-b[0];  //compareheight;
    }
}