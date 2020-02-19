129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
preorder backtracking
O(N)
O(N)
class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root,sb,lst);
        int sum=0;
        for(int i:lst){
            sum+=i;
        }
        return sum;
        
    }
    public void dfs(TreeNode root,StringBuilder sb,List<Integer> lst){
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            lst.add(Integer.parseInt(sb.toString()));
            sb.setLength(sb.length()-1);
            return;
        }
        dfs(root.left,sb,lst);
        dfs(root.right,sb,lst);
        sb.setLength(sb.length()-1);
    }
}

preorder pass by value
O(N);
O(N)
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
    int sum=0;
    public int sumNumbers(TreeNode root) {      
        dfs(0,root);
        return sum;
    }
    public void dfs(int n,TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            sum+=n*10+root.val;
            return;
        }
        dfs(n*10+root.val,root.left);
        dfs(n*10+root.val,root.right);
        
    }
}