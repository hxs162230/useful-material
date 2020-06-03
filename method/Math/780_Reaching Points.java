780. Reaching Points
Hard

410

87

Add to List

Share
A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

Examples:
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: True
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

Input: sx = 1, sy = 1, tx = 2, ty = 2
Output: False

Input: sx = 1, sy = 1, tx = 1, ty = 1
Output: True

Note:

sx, sy, tx, ty will all be integers in the range [1, 10^9].

// 
// 
// since
// sy will translate to ty only by (sx+sy), if they translate then(sx, sy+k*sx) = ty for some k
// sy+k*sx = ty => (ty-sy) / sx = k.
// Since sx,sy,tx,ty are all integer, then k has to be a integer which means, there must be a integer k that help us to reach ty. Which makes reminder to be 0
// Hence
// (ty-sy) % sx == 0

// Complexity : O(log(n)) where n = Max(tx,ty)
// 
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<tx&&sy<ty){
            if(tx<ty) ty%=tx;
            else tx%=ty;
        }

        if(tx==sx&&sy<ty&&(ty-sy)%tx==0) return true;
        else return ty==sy&&sx<tx&&(tx-sx)%ty==0;
    }
}