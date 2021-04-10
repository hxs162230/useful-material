42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

T:O(N)
S:O(N)
維持monodecresing Stack (存數組的位置)
左邊邊界沒有了(empty) =>continue


class Solution {
    public int trap(int[] height) {
        int i=0;
        int sum=0;
        Stack<Integer> stk = new Stack<>();
        while(i<height.length){
            if(stk.isEmpty()||height[i]<height[stk.peek()])
                stk.push(i++);
            else{
                int tmp = stk.pop();
                if(stk.isEmpty()) continue;
                sum+=(i-stk.peek()-1)*(Math.min(height[i],height[stk.peek()])-height[tmp]);
            }
        }
        return sum;
    }
}