450. Delete Node in a BST
Medium

1178

66

Favorite

Share
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
Accepted
82,040
Submissions
200,025

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key<root.val)
            root.left=deleteNode(root.left,key);
        else if(key>root.val)
            root.right=deleteNode(root.right,key);
        else
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                TreeNode tmp = findMin(root.right);
                int minKey = tmp.val;
                root.val=minKey;
                root.right = deleteNode(root.right,minKey);
            }
        return root;
    }
    public TreeNode findMin(TreeNode root){
        if(root==null) return null;
        while(root.left!=null)
            root=root.left;
        return root;
    }
}