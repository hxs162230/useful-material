272. Closest Binary Search Tree Value II

Given a non-empty binary search tree and a target value, 

find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

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
    Stack<TreeNode> pre = new Stack<>();
    Stack<TreeNode> next = new Stack<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> lst = new LinkedList<>();
        while(root!=null){
            if(root.val<target){
                pre.push(root);
                root=root.right;
            }
            else{
                next.push(root);
                root=root.left;
            }
        }
        while(k-->0){
            if(next.isEmpty()||!pre.isEmpty()&&target-pre.peek().val<next.peek().val-target){
                lst.add(pre.peek().val);
                updatePre();
            }
            else{
                lst.add(next.peek().val);
                updateNext();
            }
        }
        return lst;
    }
    public void updatePre(){
        TreeNode node = pre.pop();
        if(node.left!=null){
            pre.push(node.left);
            while(pre.peek().right!=null) pre.push(pre.peek().right);
        }
    }
    public void updateNext(){
        TreeNode node = next.pop();
        if(node.right!=null){
            next.push(node.right);
            while(next.peek().left!=null) next.push(next.peek().left);
        }
    }
}