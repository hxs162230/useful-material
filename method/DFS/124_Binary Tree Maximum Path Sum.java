124. Binary Tree Maximum Path Sum
Hard

2658

217

Add to List

Share
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

class Solution {
    int gloMax;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        
        gloMax = Integer.MIN_VALUE;
        
        recur(root);
        
        return gloMax;
    }
    public int recur(TreeNode root){
        if(root==null) return 0;
        
        int left=Math.max(recur(root.left),0);
        int right=Math.max(recur(root.right),0);
        gloMax=Math.max(gloMax,left+right+root.val);
        
        return Math.max(left,right)+root.val;
    }
}