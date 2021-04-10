102. Binary Tree Level Order Traversal
Medium

1904

48

Favorite

Share
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
T:O(N)
S:O(N)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       //using bfs
        
        List<List<Integer>> lol =new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return lol;
        q.add(root);
        while(q.size()>0){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=q.size();i>0;i--){ //qSize changing, must put it into ini condition!!!
                TreeNode a =q.peek();
                q.poll();
                arr.add(a.val);
                if(a.left!=null) q.add(a.left);
                if(a.right!=null) q.add(a.right);
            }
            lol.add(new ArrayList<Integer>(arr));
        }
        return lol;
    }
    
}