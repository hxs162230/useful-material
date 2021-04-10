106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

1081

23

Favorite

Share
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0) return null;
        return recur(inorder,postorder,0,inorder.length-1,postorder.length-1);
    }
    public TreeNode recur(int[] inorder,int[] postorder,int in_st,int in_end,int post_st){
        
        if(in_st>in_end ||post_st<0){
            return null;
        }
        
        TreeNode root =new TreeNode(postorder[post_st]);
        int i=0;
        while(i<in_end){
            if(inorder[i]==postorder[post_st])
                break;
            i++;
        }
        root.left=recur(inorder,postorder,in_st,i-1,post_st-1-(in_end-i));
        root.right=recur(inorder,postorder,i+1,in_end,post_st-1);
        return root;
    
    
    }
}