515. Find Largest Value in Each Tree Row
Medium

754

57

Add to List

Share
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root,0,lst);
        return lst;
    }
    public void dfs(TreeNode root,int d,List<Integer> lst){
        if(root==null) return;
        if(d>=lst.size()){
            lst.add(root.val);
        }
        dfs(root.left,d+1,lst);
        dfs(root.right,d+1,lst);
        if(lst.get(d)<root.val){
            lst.set(d,root.val);
        }
    }
}



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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return lst;
        q.add(root);
        int lv = 0;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                TreeNode cur = q.poll();
                if(lv>=lst.size()) lst.add(cur.val);
                if(lst.get(lv)<cur.val) lst.set(lv,cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            lv++;
        }
        return lst;
    }
}