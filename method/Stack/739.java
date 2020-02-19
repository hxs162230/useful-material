739. Daily Temperatures
Medium

1719

52

Favorite

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].


lc#456

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stk = new Stack<>();
        int[] warmer = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stk.isEmpty()&&T[i]>T[stk.peek()]){
                int pre = stk.pop();
                warmer[pre] = i-pre;
            }
            stk.push(i);
        }
        return warmer;
    }
}