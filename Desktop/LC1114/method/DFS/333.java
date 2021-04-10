333. Largest BST Subtree

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),

where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    in brute-force solution, we get information in a top-down manner.
    for O(n) solution, we do it in bottom-up manner, meaning we collect information during backtracking. 
*/
    

class Solution { // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
    class result{
        int size;
        int left;
        int right;
        public result(int size,int left,int right){
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }
    int max=0;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        traverse(root);
        return max;
    }
    public result traverse(TreeNode root){
        if(root==null) return new result(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        result l = traverse(root.left);
        result r = traverse(root.right); 
        if(l.size==-1||r.size==-1||root.val<=l.right||root.val>=r.left)
            return new result(-1,0,0);
        int s = l.size+r.size+1;
        max = Math.max(max,s);
        return new result(s,Math.min(root.val,l.left),Math.max(root.val,r.right));
    }
}