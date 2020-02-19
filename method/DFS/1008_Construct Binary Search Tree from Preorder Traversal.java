1008. Construct Binary Search Tree from Preorder Traversal
Medium

379

14

Favorite

Share
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.

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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length<=0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);
        return recur(preorder,0,preorder.length-1);
        
    }
    public TreeNode recur(int[] preorder,int pre_st,int pre_end){
        if(pre_st>pre_end){
            return null;
        }
        TreeNode root =new TreeNode(preorder[pre_st]);
        int i=pre_st;
        while(i<=pre_end && preorder[pre_st]>=preorder[i]){
            i++;
        }
        root.left=recur(preorder,pre_st+1,i-1);
        root.right=recur(preorder,i,pre_end);
        return root;
    }
}