968. Binary Tree Cameras
Hard

1007

19

Add to List

Share
Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Note:

The number of nodes in the given tree will be in the range [1, 1000].
Every node has value 0.




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    //return if
    //0: par of par of cam (without cam) : leaf
    //1: put cam 						 : par of leaf
    //2: par of cam (without cam)      
    public int minCameraCover(TreeNode root) {
        return (dfs(root)==0?1:0)+res;
    }
    public int dfs(TreeNode root){
        if(root==null) return 2;
        int L = dfs(root.left);
        int R = dfs(root.right);
        if(L==0||R==0){
            res++;
            return 1;
        }
        return L==1||R==1?2:0;
    }
}