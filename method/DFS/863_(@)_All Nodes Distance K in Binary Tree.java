863. All Nodes Distance K in Binary Tree
Medium

1138

23

Favorite

Share
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

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
    public List<Integer> lst=new ArrayList<>();   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
     rootTotarget(root,target,K);
     return lst;
    }
    public int rootTotarget(TreeNode root,TreeNode target,int K){
        if(root==null) return -1;
        if(root==target){
            collect(target,K); //收集子樹距離K的NODE
            return 0;
        }
        int l=rootTotarget(root.left,target,K);
        int r=rootTotarget(root.right,target,K);
        if(l>=0){ // Target in the left subtree
            if(l+1==K){ 
                lst.add(root.val);
            }
            collect(root.right,K-l-2);  // Collect nodes in right subtree with depth K - l - 2
            return 1+l;
        }
        if(r>=0){   // Target in the right subtree
            if(r+1==K){ 
                lst.add(root.val);
            }
            collect(root.left,K-r-2);  // Collect nodes in left subtree with depth K - r - 2
            return 1+r;
        }
        return -1;
    }
    public void collect(TreeNode root,int K){ // Collect nodes that are d steps from root.
        if(root==null || K<0) return;
        if(K==0){ 
            lst.add(root.val);
            //System.out.println(root.val); 
        }
        collect(root.left,K-1);
        collect(root.right,K-1);
        
    }
}