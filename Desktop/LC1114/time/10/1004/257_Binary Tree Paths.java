257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3



class Solution {
	List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
 		res = new ArrayList<>();
 		if(root==null) return res;
        dfs(root,new StringBuilder());
 		return res;       
    }
    public void dfs(TreeNode root,StringBuilder sb){
    	if(root==null) return;
    	int len = sb.length();
    	sb.append(root.val);
    	sb.append("->");
    	if(root.left==null&&root.right==null){
    		res.add(sb.toString().substring(0,sb.length()-2));	
    	}
    	dfs(root.left,sb);
    	dfs(root.right,sb);
    	sb.setLength(len);
    }
}