117. Populating Next Right Pointers in Each Node II

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, 

the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example:



Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

这道是之前那道 Populating Next Right Pointers in Each Node 的延续，原本的完全二叉树的条件不再满足，
但是整体的思路还是很相似，仍然有递归和非递归的解法。我们先来看递归的解法，这里由于子树有可能残缺，
故需要平行扫描父节点同层的节点，找到他们的左右子节点。代码如下：

这是个好问题，我试了一下，果然换了顺序过不了，对于下面这棵树：
            2
         /     \
      4         3
     / \        / \
    0   7     9   1
   /   / \       / \
  5  12  6      8   11
         /
       10

问题出在里面的7和9节点，由于9没有子节点，这块很tricky，如果我们先递归左子节点，那么当递归到节点7时，右边节点9的next还没有连上右边的节点1，那么节点7的右子节点6的next就只能NULL, 而并非右边的节点8，这就出错了。
而如果我们先递归右子节点，就不会有这个问题。

我也没想过这一点，多谢指出~

preorder

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Node tmp=root.next;                 //先找右邊節點
        while(tmp!=null){
            if(tmp.left!=null){
                tmp=tmp.left;
                break;
            }
            if(tmp.right!=null){
                tmp=tmp.right;
                break;
            }
            tmp=tmp.next;
        }
        if(root.right!=null){
            root.right.next = tmp;
        }
        if(root.left!=null)
            root.left.next = (root.right!=null?root.right : tmp);
        root.right= connect(root.right);
        root.left = connect(root.left);
   
        return root;
    }
}