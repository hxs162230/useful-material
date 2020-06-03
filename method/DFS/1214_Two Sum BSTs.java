1214. Two Sum BSTs
Medium

138

12

Add to List

Share
Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 

Example 1:



Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
Example 2:



Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false
 

Constraints:

Each tree has at most 5000 nodes.
-10^9 <= target, node.val <= 10^9

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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root1,set,target);
        return search(root2,set);
    }
    public void dfs(TreeNode root,HashSet<Integer> set,int t){
        if(root==null) return;
        set.add(t-root.val);
        dfs(root.left,set,t);
        dfs(root.right,set,t);
    }
    public boolean search(TreeNode root,HashSet<Integer> set){
        if(root==null) return false;
        if(set.contains(root.val)) return true;
        boolean L = search(root.left,set);
        boolean R = search(root.right,set);
        return L||R;
    }
}