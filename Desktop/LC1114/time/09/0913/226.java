226. Invert Binary Tree
Easy

2163

36

Favorite

Share
Invert a binary tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
postorder bottom up
T:O(N)
S:O(N)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=tmp;
        return root;
    }
}