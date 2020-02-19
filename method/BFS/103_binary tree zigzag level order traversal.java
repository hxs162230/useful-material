103. Binary Tree Zigzag Level Order Traversal
Medium

1510

84

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]



T:O(N)
S:O(N)


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null) return lol;
        q.add(root);
        int num=1;
        while(q.size()>0){
            List<Integer> arr =new ArrayList<>();
            for(int i=q.size();i>0;i--){
                TreeNode tmp = q.peek();
                q.poll();
                arr.add(tmp.val);
                
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
        
                 
            }
            if(num%2!=1)
            Collections.reverse(arr);
         
            num++;
            lol.add(new ArrayList<Integer>(arr));
        }
        return lol;
    }
}