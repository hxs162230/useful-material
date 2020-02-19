653. Two Sum IV - Input is a BST

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

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
    
    public boolean findTarget(TreeNode root, int k) {
           
    
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int left=0;
        int right=arr.size()-1;
        
        
        while(left<right){
            if(arr.get(left)+arr.get(right)<k){
                left++;
            }
            else if(arr.get(left)+arr.get(right)>k){
                right--;
            }
            else{
                return true;
            }
            
            
            
        }
        
        return false;
        
        
    }
    private void inorder(TreeNode root,List<Integer> arr){
        
        if(root==null) return;
        
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        
        
        
        
    }
}