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