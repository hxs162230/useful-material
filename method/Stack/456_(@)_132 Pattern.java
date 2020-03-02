456. 132 Pattern
Medium

834

53

Favorite

Share
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].


下面这种方法利用单调栈来做，既简洁又高效，关于单调栈可以参见博主之前的一篇文章 
LeetCode Monotonous Stack Summary 单调栈小结。思路是我们维护一个栈和一个变量 third，
其中 third 就是第三个数字，也是 pattern 132 中的2，初始化为整型最小值，
栈里面按顺序放所有大于 third 的数字，也是 pattern 132 中的3，那么我们在遍历的时候，
如果当前数字小于 third，即 pattern 132 中的1找到了，我们直接返回 true 即可，因为已经找到了，
注意我们应该从后往前遍历数组。如果当前数字大于栈顶元素，那么我们将栈顶数字取出，赋值给 third，
然后将该数字压入栈，这样保证了栈里的元素仍然都是大于 third 的，我们想要的顺序依旧存在，进一步来说，
栈里存放的都是可以维持坐标 second > third 的 second 值，其中的任何一个值都是大于当前的 third 值，
如果有更大的值进来，那就等于形成了一个更优的 second > third 的这样一个组合，并且这时弹出的 third 值比以前的 
third 值更大，为什么要保证 third 值更大，因为这样才可以更容易的满足当前的值 first 比 third 值小这个条件，
举个例子来说吧，比如 [2, 4, 2, 3, 5]，由于是从后往前遍历，所以后三个数都不会进入 while 循环，
那么栈中的数字为 5, 3, 2（其中2为栈顶元素），此时 third 还是整型最小，那么当遍历到4的时候，
终于4大于栈顶元素2了，那么 third 赋值为2，且2出栈。此时继续 while 循环，因为4还是大于新栈顶元素3，
此时 third 赋值为3，且3出栈。现在栈顶元素是5，那么 while 循环结束，将4压入栈。下一个数字2，
小于 third，则找到符合要求的序列 [2, 4, 3]，参见代码如下：

third = Pre
T:O(N)

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int pre=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(pre>nums[i]) return true;
            while(!stk.isEmpty()&&nums[i]>stk.peek()){
                pre = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}
