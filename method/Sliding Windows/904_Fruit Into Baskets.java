904. Fruit Into Baskets

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

 

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 

Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length

这道题的本质就是从任意位置开始，若最多只能收集两种水果，问最多能收集多少个水果。那么再进一步提取，
其实就是最多有两个不同字符的最长子串的长度，跟之前那道 Longest Substring with At Most Two Distinct Characters 一模一样，
只不过换了一个背景，代码基本都可以直接使用的，博主感觉这样出题有点不太好吧，完全重复了。之前那题的四种解法这里完全都可以使用，
先来看第一种，使用一个 HashMap 来记录每个水果出现次数，当 HashMap 中当映射数量超过两个的时候，我们需要删掉一个映射，
做法是滑动窗口的左边界 start 的水果映射值减1，若此时减到0了，则删除这个映射，否则左边界右移一位。
当映射数量回到两个的时候，用当前窗口的大小来更新结果 res 即可，参见代码如下：

class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0;
        int t=0;
        for(int r=0;r<tree.length;r++){
            if(map.containsKey(tree[r]))
                map.put(tree[r],map.get(tree[r])+1);
            else
                map.put(tree[r],1);
            while(map.size()>2){
                map.put(tree[l],map.get(tree[l])-1);
                if(map.get(tree[l])==0) 
                    map.remove(tree[l]);
                l++;
            }
            t=Math.max(t,r-l+1);
        }
        return t;
    }
}