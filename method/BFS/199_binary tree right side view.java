199. Binary Tree Right Side View
Medium

1375

73

Favorite

Share
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if(root==null) return lst;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size_q = q.size();
            lst.add(q.peek().val);
            for(int i=0;i<size_q;i++){
                TreeNode qNode = q.poll();
                if(qNode.right!=null) q.add(qNode.right);
                if(qNode.left!=null) q.add(qNode.left);
            }
        }
        return lst;
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//idx<=lst.size()   if idx==lst.size()   then add to lst
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        recur(lst,root,0);
        return lst;
    }
    public void recur(List<Integer> lst ,TreeNode root,int idx){
        if(root==null) return;
        if(lst.size()==idx){
            lst.add(root.val);
        }
        recur(lst,root.right,idx+1);
        recur(lst,root.left,idx+1);
    }
}