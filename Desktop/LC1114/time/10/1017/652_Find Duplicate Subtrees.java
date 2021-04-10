652. Find Duplicate Subtrees

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//o(n^2) o(n^2)   訪問每個點 N    String COPY N  
//this is postorder solution!!

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> hm =new HashMap<String,Integer>();
        List<TreeNode> lst =new ArrayList<>();
        recur(root,hm,lst);
        return lst;
    }
    public String recur(TreeNode root,HashMap<String,Integer> hm,List<TreeNode> lst){
        if(root==null) return "";
        
        String s=String.valueOf(root.val)+","+recur(root.left,hm,lst)+","+recur(root.right,hm,lst);
        if(!hm.containsKey(s))
            hm.put(s,1);
        else
        hm.put(s,hm.get(s)+1);
        
        if(hm.get(s)==2){
            lst.add(root);
        }
        return s;
    }
}