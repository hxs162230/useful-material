1382. Balance a Binary Search Tree
Medium

1280

45

Add to List

Share
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105



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
    int nodeCount = 0;
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        turnToSortList(root,lst);
        return turnLstToBalancedTree(lst,0,lst.size()-1);
    }
    public void turnToSortList(TreeNode root,List<Integer> lst){
        if(root==null) return;
        turnToSortList(root.left,lst);
        lst.add(root.val);
        turnToSortList(root.right,lst);
    }
    public TreeNode turnLstToBalancedTree(List<Integer> lst,int left,int right){
        if(left>right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(lst.get(mid));
        root.left = turnLstToBalancedTree(lst,left,mid-1);
        root.right = turnLstToBalancedTree(lst,mid+1,right);
        return root;
    }
}