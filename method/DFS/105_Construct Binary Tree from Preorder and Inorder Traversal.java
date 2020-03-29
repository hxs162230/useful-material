105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

2198

61

Favorite

Share
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        
        return recur(preorder,inorder,0,0,preorder.length-1);
        
    }
    public TreeNode recur(int[] preorder,int[] inorder,int in_st,int pre_st,int in_end){
        if(in_st>in_end || pre_st>preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_st]);
        int i=in_st;
        while(i<in_end){
            if(inorder[i]==preorder[pre_st])
                 break;
            i++;
        }
        root.left= recur(preorder,inorder,in_st,pre_st+1,i-1);
        root.right=recur(preorder,inorder,i+1,pre_st+1+(i-in_st),in_end);
        return root;
        
    }
}