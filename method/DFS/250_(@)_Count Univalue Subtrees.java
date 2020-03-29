250. Count Univalue Subtrees
Medium

355

81

Favorite

Share
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4

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
    int res=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        if(uni(root,root.val)) res++;
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return res;
    }
    public boolean uni(TreeNode root,int val){
        if(root==null) return true;
        return root.val==val && uni(root.left,val) && uni(root.right,val);
    }
 
}

但是上面的那种解法不是很高效，含有大量的重复check，我们想想能不能一次遍历就都搞定，我们这样想，
符合条件的相同值的字数肯定是有叶节点的，而且叶节点也都相同(注意单独的一个叶节点也被看做是一个相同值子树)，
那么我们可以从下往上check，采用后序遍历的顺序，左右根，我们还是递归调用函数，对于当前遍历到的节点，
如果对其左右子节点分别递归调用函数，返回均为true的话，那么说明当前节点的值和左右子树的值都相同，
那么又多了一棵树，所以结果自增1，然后返回当前节点值和给定值(其父节点值)是否相同，
从而回归上一层递归调用。这里特别说明一下在子函数中要使用的那个单竖杠或，为什么不用双竖杠的或，
因为单竖杠的或是位或，就是说左右两部分都需要被计算，然后再或，C++这里将true当作1，false当作0，
然后进行Bit OR 运算。不能使用双竖杠或的原因是，如果是双竖杠或，一旦左半边为true了，
整个就直接是true了，右半边就不会再计算了，这样的话，一旦右子树中有值相同的子树也不会被计算到结果res中了
，参见代码如下：

class Solution {
    int res=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        isuni(root,root.val);
        return res;
    }
    public boolean isuni(TreeNode root,int curval){
        if(root==null) return true;
        if(!isuni(root.left,root.val)|!isuni(root.right,root.val)) return false;
        res++;
        return root.val == curval; 
    }
}