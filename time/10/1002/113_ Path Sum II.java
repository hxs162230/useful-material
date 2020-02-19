113. Path Sum II

Given a binary tree and a sum, 

find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        dfs(root,sum,res,sol);
        return res;
    }
    public void dfs(TreeNode root,int sum,List<List<Integer>> res, List<Integer> sol){
        if(root==null) return;
        sol.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            res.add(new ArrayList<>(sol));
            sol.remove(sol.size()-1);
            return;
        }
        dfs(root.left,sum-root.val,res,sol);
        dfs(root.right,sum-root.val,res,sol);
        sol.remove(sol.size()-1);
    }
}