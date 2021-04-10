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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lol =new ArrayList<List<Integer>>();
        if(root==null) return lol;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int i=0;
        q1.add(i);
        q2.add(root);
        int minIdx = 0;
        int maxIdx = 0;
        while(!q2.isEmpty()){
            int idx = q1.poll();
            TreeNode tmp = q2.poll();
            if(!map.containsKey(idx))
                map.put(idx,new ArrayList<Integer>());
            
                map.get(idx).add(tmp.val);
            if(tmp.left!=null){
                q1.add(idx-1);
                q2.add(tmp.left);
                minIdx=Math.min(minIdx,idx-1);
            }
            if(tmp.right!=null){
                q1.add(idx+1);
                q2.add(tmp.right);
                maxIdx=Math.max(maxIdx,idx+1);
            }
        }
        for(int j=minIdx;j<=maxIdx;j++){
            lol.add(map.get(j));
        }
        return lol;
    }
}