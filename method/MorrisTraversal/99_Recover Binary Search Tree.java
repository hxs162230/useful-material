99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

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
    List<TreeNode> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(lst2);
        int i = 0;
        for(TreeNode node:lst1){
            node.val = lst2.get(i++);
        }
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        lst1.add(root);
        lst2.add(root.val);
        inorder(root.right);
    }
}

sol2:
这道题的真正符合要求的解法应该用的Morris遍历，这是一种非递归且不使用栈，空间复杂度为O(1)的遍历方法，
可参见我之前的博客 Binary Tree Inorder Traversal，在其基础上做些修改，
加入first, second和parent指针，
来比较当前节点值和中序遍历的前一节点值的大小，跟上面递归算法的思路相似，代码如下：
Then, come to how to specify the first wrong node and second wrong node.

When they are not consecutive, the first time we meet pre.val > root.val ensure us 
the first node is the pre node, since root should be traversal ahead of pre, pre 
should be at least at small as root. The second time we meet pre.val > root.val ensure 
us the second node is the root node, since we are now looking for a node to replace with out 
first node, which is found before.

When they are consecutive, which means the case pre.val > cur.val will appear only once. 
We need to take case this case without destroy the previous analysis. 
So the first node will still be pre, and the second will be just set to root. 
Once we meet this case again, the first node will not be affected.

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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first=null,second=null,parent=null;
        while(cur!=null){
            if(cur.left==null){
                if(parent!=null&&parent.val>cur.val){
                    if(first==null) first = parent;
                    second = cur;
                }
                parent = cur;
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right!=null&&pre.right!=cur) pre = pre.right;
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }
                else{
                    pre.right=null;
                    if(parent.val>cur.val){
                    if(first==null) first = parent;
                    second = cur;
                    }
                    parent = cur;
                    cur=cur.right;
                }
            }
        }
        if(first!=null&&second!=null)
            swap(first,second);
        
    }
    public void swap(TreeNode f,TreeNode s){
        int tmp = f.val;
        f.val = s.val;
        s.val = tmp;
    }
}



class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode par = null;
        TreeNode first = null;
        TreeNode second = null;
        while(!stk.isEmpty()||cur!=null){
            while(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            if(par!=null&&par.val>cur.val){
                second = cur;
                if(first==null) first = par;
                else break;
            }
            par = cur;
            cur = cur.right;
        }
         if(first!=null&&second!=null){
             int tmp = first.val;
             first.val = second.val;
             second.val = tmp;
         }    
    }
   
}