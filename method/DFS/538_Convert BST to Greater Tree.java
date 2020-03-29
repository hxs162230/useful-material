538. Convert BST to Greater Tree

Given a Binary Search Tree (BST), convert it to a Greater Tree 

such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        int[] sum = {0};
        rev_inorder(root,sum);
        return root;
    }
    public void rev_inorder(TreeNode root,int[] sum){
        if(root==null) return;
        rev_inorder(root.right,sum);
        sum[0]+=root.val;
        root.val=sum[0];
        rev_inorder(root.left,sum);
    }
    
}