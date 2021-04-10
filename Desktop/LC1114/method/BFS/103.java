T:O(N)
S:O(N)


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null) return lol;
        q.add(root);
        int num=1;
        while(q.size()>0){
            List<Integer> arr =new ArrayList<>();
            for(int i=q.size();i>0;i--){
                TreeNode tmp = q.peek();
                q.poll();
                arr.add(tmp.val);
                
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
        
                 
            }
            if(num%2!=1)
            Collections.reverse(arr);
         
            num++;
            lol.add(new ArrayList<Integer>(arr));
        }
        return lol;
    }
}