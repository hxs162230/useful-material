230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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
    int num;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        num=k;
        return recur(root);
    }
    public int recur(TreeNode root){
        if(root==null) 
            return 0;
        recur(root.left);
        num--;
        if(num==0){ 
            res=root.val;
            return res;
        }
        recur(root.right);
        return res;
    }
}

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(!stk.isEmpty()||cur!=null){
            while(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            TreeNode tmp = stk.pop();
            k--;
            if(k==0){
                return tmp.val;
            }
            cur = tmp.right;
        }
        return -1;
    }
}