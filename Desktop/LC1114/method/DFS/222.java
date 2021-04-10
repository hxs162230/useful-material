Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 

is completely filled, and all nodes in the last level are as far left as possible. 

It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

T:O(log(N)*log(N))



class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int ls=0;
        int rs=0;
        TreeNode l = root;
        TreeNode r = root;
        while(l!=null){
            ls++;
            l = l.left;
        }
        while(r!=null){
            rs++;
            r = r.right;
        }
        if(ls==rs) return (int)Math.pow(2,ls)-1;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}