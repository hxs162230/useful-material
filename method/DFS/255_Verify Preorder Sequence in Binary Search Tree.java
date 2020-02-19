255. Verify Preorder Sequence in Binary Search Tree

Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return valid(preorder,0,preorder.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean valid(int[] preorder,int st,int ed,int min,int max){
        if(st>ed) return true;
        int val = preorder[st];
        if(val<=min||val>=max) return false;
        int i=0;
        for(i=st+1;i<=ed;i++){
            if(preorder[i]>=val) break;
        }
        return valid(preorder,st+1,i-1,min,val) && valid(preorder,i,ed,val,max);
    }
}