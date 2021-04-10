437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
preorder pathSum 
class Solution {
    int cnt=0;
    List<TreeNode> lst;
    public int pathSum(TreeNode root, int sum) {
        lst = new ArrayList<>();
        dfs(root,sum,0);
        return cnt;
    }
    public void dfs(TreeNode root,int sum,int curSum){
        if(root==null) return;
        curSum+=root.val;
        lst.add(root);
        if(curSum==sum) cnt++;
        int t = curSum;
        for(int i=0;i<lst.size()-1;i++){
            t-=lst.get(i).val;
            if(t==sum) cnt++;
        }
        dfs(root.left,sum,curSum);
        dfs(root.right,sum,curSum);
        lst.remove(lst.size()-1);
    }
}