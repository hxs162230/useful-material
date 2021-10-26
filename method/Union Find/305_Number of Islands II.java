305. Number of Islands II
Hard

805

20

Add to List

Share
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
Follow up:

Can you do it in time complexity O(k log mn), where k is the length of the positions?


class Solution {
    int[] pre;
    int[] height;
    int cnt;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        this.pre = new int[m*n];
        //important to init all -1
        Arrays.fill(pre,-1);
        this.height = new int[m*n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //for(int i=0;i<pre.length;i++) pre[i] = i;
        this.cnt = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] pos:positions){
            if(pre[pos[0]*n+pos[1]]!=-1){
                res.add(cnt);
                continue;
            } 
            int n1 = pos[0]*n+pos[1];
            pre[n1] = n1;
            cnt++;
            //find nb
            for(int[] dir:dirs){
                int x = pos[0]+dir[0];
                int y = pos[1]+dir[1];
                if(x<0||y<0||x>=m||y>=n) continue;
                int n2 = x*n+y;
                if(pre[n2]!=-1){
                    if(findroot(n1)!=findroot(n2)){
                        union(n1,n2);
                    }
                }
                
            }
            res.add(cnt);
        }
        return res;
    }
    public void union(int i,int j){
        int x = findroot(i);
        int y = findroot(j);
        if(x==y) return;
        if(height[x]<height[y]){
            pre[x] = y;
        }
        else if(height[y]<height[x]){
            pre[y] = x;
        }
        else{
            pre[x] = y;
            ++height[y];
        }
        this.cnt--;
    }
    public int findroot(int i){
        if(pre[i]==i) return i;
        return pre[i] = findroot(pre[i]);
    }
}