963.   
Medium

120

200

Add to List

Share
Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the x and y axes.

If there isn't any rectangle, return 0.

 

Example 1:



Input: [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
Example 2:



Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
Example 3:



Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.
Example 4:



Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.
 

Note:

1 <= points.length <= 50
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
Answers within 10^-5 of the actual value will be accepted as correct.

class Solution {
    public double minAreaFreeRect(int[][] points) {
        int m = points.length;
        if(m==0) return 0.0;
        int n = points[0].length;
        double res = Double.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            set.add(String.valueOf(p[0]+","+p[1]));
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=j+1;k<m;k++){
                    if(i==j||i==k) continue;
                    int[] vector1 = vector(points,j,i);
                    int[] vector2 = vector(points,j,k);
                    if(vector1[0]*vector2[0]+vector1[1]*vector2[1]!=0) continue;
                    int p4x = points[i][0]+points[k][0]-points[j][0];
                    int p4y = points[i][1]+points[k][1]-points[j][1];
                    if(!set.contains(String.valueOf(p4x+","+p4y))) continue;
                    double area = dist(vector1[0],vector1[1])*dist(vector2[0],vector2[1]);
                    res = Math.min(res,area);
                }
            }
        }
        return res==Double.MAX_VALUE?0:res;
    }
    public double dist(int x,int y){
        return Math.sqrt(x*x+y*y);
    }
    public int[] vector(int[][] p,int a,int b){
        int[] res = new int[2];
        res[0] = p[b][0]-p[a][0];
        res[1] = p[b][1]-p[a][1];
        return res;
    }
}