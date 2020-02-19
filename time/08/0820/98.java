98. Validate Binary Search Tree
Medium

2545

372

Favorite

Share
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

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
    public boolean isValidBST(TreeNode root) {
        return prove(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean prove(TreeNode root,long min,long max){
        if(root==null) return true;
        //System.out.print(max);922337203685477580729223372036854775807
        if(root.val<=min||root.val>=max) return false;
        boolean left = prove(root.left,min,root.val);
        boolean right = prove(root.right,root.val,max);
        if(left&&right) return true;
        else return false;
    }
}