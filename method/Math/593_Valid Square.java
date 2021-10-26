593. Valid Square
Medium

242

414

Add to List

Share
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
 

Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] container = {{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        List<double[]> lst = new ArrayList<>();
        int[] cand = container[0];
        
        for(int i=1;i<4;i++){
            int[] p = container[i];
            int[] v = vector(cand,p);
            if(v[0]==0&&v[1]==0) return false;
            double d = distance(v[0],v[1]);
            lst.add(new double[]{d,i});
        }
        
        Collections.sort(lst,(a,b)->a[0]!=b[0]?a[0]<b[0]?-1:1:0);
        
        if(cand[0]+container[(int)lst.get(2)[1]][0]!=container[(int)lst.get(0)[1]][0]+container[(int)lst.get(1)[1]][0]) return false;
        if(cand[1]+container[(int)lst.get(2)[1]][1]!=container[(int)lst.get(0)[1]][1]+container[(int)lst.get(1)[1]][1]) return false;
        int[] v1 = vector(cand,container[(int)lst.get(2)[1]]);
        int[] v2 = vector(container[(int)lst.get(0)[1]],container[(int)lst.get(1)[1]]);
        
        int val = v1[0]*v2[0]+v1[1]*v2[1];
        return val==0;
    }
    
    public double distance(int i,int j){
        return Math.sqrt(i*i+j*j);
    }
    public int[] vector(int[] p1,int[] p2){
        int dx = p2[0]-p1[0];
        int dy = p2[1]-p1[1];
        return new int[]{dx,dy};
    }
}