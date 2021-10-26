742. Closest Leaf in a Binary Tree
Medium

445

94

Add to List

Share
Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.


time O(N)
space O(N)
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        buildGraph(root,map,root.val,leaves);
        
        return bfs(k,map,leaves);
    
    }
    public void buildGraph(TreeNode root,Map<Integer,Set<Integer>> map,int par,Set<Integer> leaves){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            leaves.add(root.val);
        }
        map.putIfAbsent(root.val,new HashSet<>());
        if(par!=root.val)
            map.get(root.val).add(par);
        if(root.left!=null)
            map.get(root.val).add(root.left.val);
        if(root.right!=null)
            map.get(root.val).add(root.right.val);
        buildGraph(root.left,map,root.val,leaves);
        buildGraph(root.right,map,root.val,leaves);
    }
    public int bfs(int cur,Map<Integer,Set<Integer>> map,Set<Integer> leaves){
        if(leaves.contains(cur)) return cur;
        Queue<Integer> q = new LinkedList<>();
        //int step = 0;
        q.add(cur);
        Set<Integer> seen = new HashSet<>();
        seen.add(cur);
        while(!q.isEmpty()){
            for(int s = q.size();s>0;s--){
                int cn = q.poll();
                for(int next : map.get(cn)){
                    if(seen.contains(next)) continue;
                    if(leaves.contains(next)) return next;
                    seen.add(next);
                    q.add(next);
                }
            }
            //step++;
        }
        return cur;
    }
}