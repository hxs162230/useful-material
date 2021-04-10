107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> lol=new ArrayList<List<Integer>>();
        if(root==null) return lol;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> lst=new ArrayList<>();    
            for(int i=q.size();i>0;i--){
                TreeNode tmp =q.peek();
                q.poll();
                lst.add(tmp.val);
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            lol.add(0,lst);
        }
        return lol;
        
    }
}