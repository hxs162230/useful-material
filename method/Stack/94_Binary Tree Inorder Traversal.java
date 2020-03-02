94. Binary Tree Inorder Traversal
Medium

2485

104

Add to List

Share
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
T:O(N)
S:O(N)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null||!stk.isEmpty()){
            while(cur!=null){
                stk.push(cur);
                cur=cur.left;
            }
            TreeNode tmp = stk.pop();
            lst.add(tmp.val);
            cur=tmp.right;
        }
        return lst;
    }
}


Morris inorderTraversal
T:O(N)
S:O(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left==null){
                lst.add(cur.val);       沒更小的值
                cur=cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right!=null&&pre.right!=cur) pre = pre.right;
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }
                else{
                    pre.right=null;         發現環   
                    lst.add(cur.val);
                    cur=cur.right;
                }
            }
        }
         return lst;
    }
}