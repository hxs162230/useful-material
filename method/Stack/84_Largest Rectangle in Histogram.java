84. Largest Rectangle in Histogram
Hard

2845

70

Add to List

Share
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10

T:O(N)
S:O(N)


class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk =new Stack<>();
        int max = 0;
        int i=0;
        
        while(i<=heights.length){
            int h = (i==heights.length?0:heights[i]);
            if(stk.isEmpty() || h>heights[stk.peek()]){
                stk.push(i++);
                //System.out.print(i+" 2");
            }
            else{
                int tmp = stk.peek();
                stk.pop();
                //System.out.print(i+" 1");
                max = Math.max(max,heights[tmp]*(stk.isEmpty()?i:(i-stk.peek()-1)));
            }
        }
        return max;
    }
}