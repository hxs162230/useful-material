223. Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:


 --------------C,D
|               |
|               |
A,B-------------

 -------------G,H
|               |
|               |
E,F-------------
Assume that the total area is never beyond the maximum possible value of int.

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C-A)*(D-B);
        int areaB = (G-E)*(H-F);
        int right = Math.min(C,G);
        int bot = Math.max(B,F);
        int left =Math.max(A,E);
        int top = Math.min(D,H);
        int overlap = 0;
        if(top>bot&&right>left){
            overlap+=(top-bot)*(right-left);
        }
        return areaA + areaB - overlap;
    }
}