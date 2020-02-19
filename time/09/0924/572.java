572. Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same 
structure and node values with a subtree of s. A subtree of s is a 
tree consists of a node in s and all of this node's descendants. 
The tree s could also be considered as a subtree of itself.
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null ) return false;
        if(isSame(s,t)){
            return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    public boolean isSame(TreeNode s,TreeNode p){
        if(s==null && p==null) return true;
        if(s==null||p==null) return false;
        if(s.val!=p.val) return false;
        return isSame(s.left,p.left) && isSame(s.right,p.right);
    
    }
}