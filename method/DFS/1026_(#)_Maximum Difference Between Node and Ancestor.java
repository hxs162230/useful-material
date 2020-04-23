1026. Maximum Difference Between Node and Ancestor
Medium

366

19

Add to List

Share
Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)

 

Example 1:



Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: 
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 

Note:

The number of nodes in the tree is between 2 and 5000.
Each node will have value between 0 and 100000.

此題重點在父點子點的"絕對差值" (父點不一定比左子點大或父點不一定比右子點小)
可用preorder維護 min  max
遇到null return max - min;


think of this case
           2
null                 5000
               5             null

return |2-5000|  = 4998
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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root,int max,int min){
        if(root==null) return max-min;
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        int L = dfs(root.left,max,min);
        int R = dfs(root.right,max,min);
        return Math.max(L,R);
    }
}