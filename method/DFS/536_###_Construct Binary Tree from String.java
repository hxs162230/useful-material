536. Construct Binary Tree from String
Medium

387

90

Add to List

Share
You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".



O(N) for time;
O(N) space

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
    public TreeNode str2tree(String s) {
        if(s==null||s.length()==0) return null;
        
        int idx = s.indexOf("(");
        
        if(idx==-1) return new TreeNode(Integer.parseInt(s));
        
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,idx)));
        int leftcnt = 0;
        int start = idx;
        int i = idx;
        for(;i<s.length();i++){
            if(s.charAt(i)=='(') leftcnt++;
            if(s.charAt(i)==')') leftcnt--;
            if(leftcnt==0&&start==idx){
                root.left = str2tree(s.substring(start+1,i));
                start = i+1;
            }
            else if(leftcnt==0){
                root.right = str2tree(s.substring(start+1,i));
            }
        }
        
        
        return root;
    }
   
}