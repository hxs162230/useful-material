513. Find Bottom Left Tree Value
Medium

679

114

Favorite

Share
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode lowestLeft=root;
        q.offer(root);
        while(!q.isEmpty()){
            lowestLeft = q.peek();
            for(int i=q.size();i>0;i--){
                TreeNode cur = q.poll();
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
        }
        return lowestLeft.val;
    }
}



class Solution {
    int maxdep=0;
    int leftmost=0;
    public int findBottomLeftValue(TreeNode root) {
        leftmost=root.val;
        dfs(root,0);
        return leftmost;
    }
    public void dfs(TreeNode root,int dep){
        if(root==null) return;
        if(dep>maxdep){
            maxdep = dep;
            leftmost = root.val;
        }
        dfs(root.left,dep+1);
        dfs(root.right,dep+1);
    }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root,0,lst);
        return lst.get(lst.size()-1);
    }
    public void dfs(TreeNode root,int lv,List<Integer> lst){
        if(root==null) return;
        if(lst.size()==lv){
            lst.add(root.val);
        }
        dfs(root.left,lv+1,lst);
        dfs(root.right,lv+1,lst);
    }
}