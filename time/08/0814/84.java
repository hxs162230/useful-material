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