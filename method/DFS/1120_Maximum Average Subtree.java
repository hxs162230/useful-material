1120. Maximum Average Subtree
Medium

257

8

Add to List

Share
Given the root of a binary tree, find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)

 

Example 1:



Input: [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
 

Note:

The number of nodes in the tree is between 1 and 5000.
Each node will have a value between 0 and 100000.
Answers will be accepted as correct if they are within 10^-5 of the correct answer.




time O(n)
space O(n)


class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        return dfs(root)[2];
    }
    public double[] dfs(TreeNode root){
        if(root==null) return new double[]{0.0,0.0,0.0};
        
        double[] L = dfs(root.left);
        double[] R = dfs(root.right);
        double child = Math.max(L[2],R[2]);
        double count = L[1]+R[1]+1;
        double sum = L[0]+R[0]+root.val;
        double maxVal = Math.max(child,sum/count);
        return new double[]{sum,count,maxVal};
    }
}