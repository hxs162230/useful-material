145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        if(root==null) return lst;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        stk.add(cur);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            lst.add(0,node.val);
            if(node.left!=null) stk.push(node.left);
            if(node.right!=null) stk.push(node.right);
        }
        return lst;
    }
}