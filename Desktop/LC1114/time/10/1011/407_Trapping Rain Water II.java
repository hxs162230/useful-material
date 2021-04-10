407. Trapping Rain Water II

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

 

Note:

Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

 

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.


The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.

 



After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length<=2||heightMap[0].length<=2) return 0;
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] seen = new boolean[m][n];
        int mx = Integer.MIN_VALUE;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new cmp());
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==n-1){
                    seen[i][j] = true;
                    pq.add(new int[]{heightMap[i][j],i*n+j});
                }
            }
        }
        while(!pq.isEmpty()){
            int[] point = pq.poll();
            int h = point[0];
            int ox = point[1]/n;
            int oy = point[1]%n;
            mx = Math.max(mx,h); //海平面
            for(int[] d:dir){
                int nx = ox+d[0];
                int ny = oy+d[1];
                if(nx<0||ny<0||nx>=m||ny>=n||seen[nx][ny]) continue;
                seen[nx][ny]=true;
                if(heightMap[nx][ny]<mx) res+=mx-heightMap[nx][ny];
                pq.add(new int[]{heightMap[nx][ny],nx*n+ny});
            }
        }
        return res;
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]-b[0];
    }
}