939. Minimum Area Rectangle
Medium

672

130

Add to List

Share
Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

 

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.


class Solution {
    public int minAreaRect(int[][] points) {
        int res = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points) set.add(p[0]+","+p[1]);
        
        for(int i =0;i<points.length;i++){
            //System.out.println(p[0]+","+p[1]);
            for(int j =i+1;j<points.length;j++){
                int dx1 = points[j][0]-points[i][0];
                int dy1 = points[j][1]-points[i][1];
                if(dx1==0 || dy1==0) continue;
                
                int vx1 = points[i][0];
                int vy1 = points[j][1];
                
                int vx2 = points[j][0];
                int vy2 = points[i][1];
                
                if(set.contains(vx1+","+vy1)&&set.contains(vx2+","+vy2))
                    res = Math.min(res,Math.abs((points[i][1]-points[j][1])*(points[i][0]-points[j][0])));
            }
        }
        
        return res==Integer.MAX_VALUE?0:res;
    }
}