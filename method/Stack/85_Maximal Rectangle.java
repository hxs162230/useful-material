85. Maximal Rectangle
Hard

2135

57

Add to List

Share
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
T:O(N*N)
S:O(N)


class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length<=0||matrix[0].length<=0) return 0;
        int x_len = matrix.length;
        int y_len = matrix[0].length;
        int res = 0;
        int[] height = new int[y_len];
        for(int i=0;i<x_len;i++){
            
            for(int j=0;j<y_len;j++){
                height[j] = (matrix[i][j]=='0'?0:1+height[j]);
            }
             res = Math.max(res,histogramArea(height));
        }
        return res;
    }
    public int histogramArea(int[] height){
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        int ini = 0;
        while(ini<=height.length){
            int h = (ini==height.length?0:height[ini]);
            if(stk.isEmpty()||h>height[stk.peek()]){
                stk.push(ini++);
            }
            else{
                int tmp = stk.peek();
                stk.pop();
                ans = Math.max(ans,height[tmp]*(stk.isEmpty()?ini:ini-stk.peek()-1));
            }
        }
        return ans;
    }
}