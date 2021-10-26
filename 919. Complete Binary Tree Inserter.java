919. Complete Binary Tree Inserter
Medium

597

73

Add to List

Share
A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.

Implement the CBTInserter class:

CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
TreeNode get_root() Returns the root node of the tree.
 

Example 1:


Input
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
Output
[null, 1, 2, [1, 2, 3, 4]]

Explanation
CBTInserter cBTInserter = new CBTInserter([1, 2]);
cBTInserter.insert(3);  // return 1
cBTInserter.insert(4);  // return 2
cBTInserter.get_root(); // return [1, 2, 3, 4]
 

Constraints:

The number of nodes in the tree will be in the range [1, 1000].
0 <= Node.val <= 5000
root is a complete binary tree.
0 <= val <= 5000
At most 104 calls will be made to insert and get_root.


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
class CBTInserter {
    
    List<TreeNode> lst = new ArrayList<>();;
    public CBTInserter(TreeNode root) {
        putIntoList(root);       
    }
    
    public void putIntoList(TreeNode root){
        TreeNode node = root;
    
        lst.add(node);
        for(int i = 0;i<lst.size();i++){
            if(lst.get(i).left!=null) lst.add(lst.get(i).left);
            if(lst.get(i).right!=null) lst.add(lst.get(i).right);
        }

    }
    
    public int insert(int val) {
        int size = lst.size();
        TreeNode node = new TreeNode(val);
        lst.add(node);
        //even add to someone's right
        if(size%2==0){
            TreeNode par = lst.get((size-1)/2);
            par.right = node;
            return par.val;
        }
        //odd=> add to someone's left
        else{
            TreeNode par = lst.get((size-1)/2);
            par.left = node;
            return par.val;
        }
    }
    
    public TreeNode get_root() {
        return lst.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */