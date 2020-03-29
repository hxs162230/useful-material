449. Serialize and Deserialize BST
Medium

838

55

Favorite

Share
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

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
preorder recursion 加入StirngBuilder

依據指針還原狀態 preorder form (超出範圍記得退位一次然後返回)

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        recurSE(sb,root);
        return sb.toString();
    }
    public void recurSE(StringBuilder sb,TreeNode root){
        if(root==null) return;
        sb.append(root.val);
        sb.append(",");
        recurSE(sb,root.left);
        recurSE(sb,root.right);
    }

    // Decodes your encoded data to tree.
     public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] node = data.split("\\,");
        int[] idx={-1};
        return recurDE(node,idx,Integer.MIN_VALUE,Integer.MAX_VALUE);
     }
    public TreeNode recurDE(String[] node,int[] idx,int min,int max){
        idx[0]++;
        if(idx[0]>=node.length) return null;
        int val = Integer.parseInt(node[idx[0]]);
        if(val<min||val>max){
            idx[0]--;
            return null;
        }
        TreeNode root = new TreeNode(val);
        root.left = recurDE(node,idx,min,root.val);
        root.right = recurDE(node,idx,root.val,max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));