314. Binary Tree Vertical Order Traversal
Medium

696

134

Favorite

Share
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lol =new ArrayList<List<Integer>>();
        if(root==null) return lol;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int i=0;
        q1.add(i);
        q2.add(root);
        int minIdx = 0;
        int maxIdx = 0;
        while(!q2.isEmpty()){
            int idx = q1.poll();
            TreeNode tmp = q2.poll();
            if(!map.containsKey(idx))
                map.put(idx,new ArrayList<Integer>());
            
                map.get(idx).add(tmp.val);
            if(tmp.left!=null){
                q1.add(idx-1);
                q2.add(tmp.left);
                minIdx=Math.min(minIdx,idx-1);
            }
            if(tmp.right!=null){
                q1.add(idx+1);
                q2.add(tmp.right);
                maxIdx=Math.max(maxIdx,idx+1);
            }
        }
        for(int j=minIdx;j<=maxIdx;j++){
            lol.add(map.get(j));
        }
        return lol;
    }
}