298. Binary Tree Longest Consecutive Sequence
Medium

470

111

Add to List

Share
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.


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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0,root.val);
        return max;
    }
    public void dfs(TreeNode root,int curlen,int t){
        if(root==null) return ;
        if(t==root.val){
            curlen++;
        }
        else{
            curlen=1;
        }
        max = Math.max(curlen,max);
        dfs(root.left,curlen,root.val+1);
        dfs(root.right,curlen,root.val+1);
    }
}