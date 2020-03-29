297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

T:O(N)
S:O(N)
大致跟 449 一樣 
在encode時遇到 NULL ROOT 可寫入StringBuilder

decode時遇到NULL VALUE返還 NULL

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurSe(root,sb);
        return sb.toString().substring(1);
    }
    public void recurSe(TreeNode root,StringBuilder sb){
        sb.append(",");
        if(root==null){
             sb.append("null");
             return;
        }    
        sb.append(root.val);
        recurSe(root.left,sb);
        recurSe(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split("\\,");
        int[] idx = {-1};
        return recurDe(idx,node);
    }
    public TreeNode recurDe(int[] idx,String[] node){
        idx[0]++;
        if(node[idx[0]].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node[idx[0]]));
        root.left = recurDe(idx,node);
        root.right = recurDe(idx,node);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));