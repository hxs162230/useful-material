110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

preorder O(nlogn)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1) return false;
        else 
            return isBalanced(root.left)&&isBalanced(root.right);        
        
        
    }
    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
}

postorder O(n)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(checkDepth(root)==-1) return false;
        return true;
    }
    public int checkDepth(TreeNode root){
        if(root==null) return 0;
        int L = checkDepth(root.left);
        if(L==-1) return -1;
        int R = checkDepth(root.right);
        if(R==-1) return -1;
        int dep = Math.abs(L-R);
        if(dep>1) return -1;
        else return 1+Math.max(L,R);
    }
}