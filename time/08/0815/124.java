class Solution {
    int gloMax;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        
        gloMax = Integer.MIN_VALUE;
        
        recur(root);
        
        return gloMax;
    }
    public int recur(TreeNode root){
        if(root==null) return 0;
        
        int left=Math.max(recur(root.left),0);
        int right=Math.max(recur(root.right),0);
        gloMax=Math.max(gloMax,left+right+root.val);
        
        return Math.max(left,right)+root.val;
    }
}