1274. Number of Ships in a Rectangle
Hard

154

21

Add to List

Share
(This problem is an interactive problem.)

Each ship is located at an integer point on the sea represented by a cartesian plane, and each integer point may contain at most 1 ship.

You have a function Sea.hasShips(topRight, bottomLeft) which takes two points as arguments and returns true If there is at least one ship in the rectangle represented by the two points, including on the boundary.

Given two points: the top right and bottom left corners of a rectangle, return the number of ships present in that rectangle. It is guaranteed that there are at most 10 ships in that rectangle.

Submissions making more than 400 calls to hasShips will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example :



Input: 
ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
Output: 3
Explanation: From [0,0] to [4,4] we can count 3 ships within the range.
 

Constraints:

On the input ships is only given to initialize the map internally. You must solve this problem "blindfolded". In other words, you must find the answer using the given hasShips API, without knowing the ships position.
0 <= bottomLeft[0] <= topRight[0] <= 1000
0 <= bottomLeft[1] <= topRight[1] <= 1000
topRight != bottomLeft

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return dfs(topRight,bottomLeft,sea);
    }
    
    public int dfs(int[] tr,int[] bl,Sea sea){
        if(tr[0]<bl[0]||tr[1]<bl[1]) return 0;
        if(!sea.hasShips(tr,bl)) return 0;
        if(tr[0]==bl[0]&&tr[1]==bl[1]) return 1;
        int midx = bl[0]+(tr[0]-bl[0])/2;
        int midy = bl[1]+(tr[1]-bl[1])/2;
        int ans = 0;
        //lelftBot
        ans+=dfs(new int[]{midx,midy},bl,sea);
        //rigthBot
        ans+=dfs(new int[]{tr[0],midy},new int[]{midx+1,bl[1]},sea);
        //leftTop
        ans+=dfs(new int[]{midx,tr[1]},new int[]{bl[0],midy+1},sea);
        //rightTop
        ans+=dfs(tr,new int[]{midx+1,midy+1},sea);
        return ans;
    }
}