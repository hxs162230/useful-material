270. Closest Binary Search Tree Value
Easy

516

38

Favorite

Share
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

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
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        int val = root.val;
        while(cur!=null){
            if(Math.abs(target-cur.val)<Math.abs(target-val)){
                val = cur.val;
            }
            if(target<cur.val) cur = cur.left;
            else if (target>cur.val) cur = cur.right;
            else return cur.val;
        }
        return val;
    }
}