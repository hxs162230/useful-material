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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int ls=0;
        int rs=0;
        TreeNode l = root;
        TreeNode r = root;
        while(l!=null){
            ls++;
            l = l.left;
        }
        while(r!=null){
            rs++;
            r = r.right;
        }
        if(ls==rs) return (int)Math.pow(2,ls)-1;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}