679. 24 Game

You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.

class Solution {
    static final double eps = 1e-6;
    List<Double> lst = new ArrayList<>();
    boolean canbe24 = false;
    public boolean judgePoint24(int[] nums) {
        for(int num:nums) lst.add((double)num);
        dfs(lst);
        return canbe24;
    }
    public void dfs(List<Double> lst){
        if(canbe24) return;
        if(lst.size()==1&&Math.abs(lst.get(0)-24)<eps){
            canbe24=true;
            return;
        }
        for(int i=0;i<lst.size()-1;i++){
            for(int j=i+1;j<lst.size();j++){
                double x =lst.get(i);
                double y =lst.get(j);
                List<Double> set = new ArrayList<>();
                set.add(x+y);
                set.add(x-y);
                set.add(x*y);
                set.add(y-x);
                if(Math.abs(x)>eps) set.add(y/x);
                if(Math.abs(y)>eps) set.add(x/y);
                lst.remove(j);                  //先移除外側 不然IDX出錯
                lst.remove(i);                  //再來移除內側
                for(double d:set){
                    if(Math.abs(d)<eps) continue;
                    lst.add(d);
                    dfs(lst);
                    lst.remove(lst.size()-1);
                }
                lst.add(i,x);
                lst.add(j,y);
            }
        }
    }
}