144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null) return lst;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        stk.add(cur);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            lst.add(node.val);
            if(node.right!=null) stk.push(node.right);
            if(node.left!=null) stk.push(node.left);
        }
        return lst;
    }
}

O(N) time
O(1) space
preorder morris traversal method
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        List<Integer> lst = new ArrayList<>();
        if(root==null) return lst;
        while(cur!=null){
            if(cur.left==null){
                lst.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right!=cur&&pre.right!=null) pre = pre.right;
                if(pre.right==null){
                    lst.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return lst;
    }
}