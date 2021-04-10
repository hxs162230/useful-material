987. Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
Queue1存位置(X,Y)
Queue2存node
HashMap從做映射(X=>List) 
List裡面做排序(依據 Y value和 大小值(如果Y value 一樣))


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        if(root==null) return lol;
        int max=0;
        int min=0;
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        Queue<int[]> idx = new LinkedList<>();
        Queue<TreeNode> node = new LinkedList<>();
        idx.add(new int[]{0,0});
        node.add(root);
        while(!node.isEmpty()){
            int[] tmp = idx.poll();
            int i=tmp[0];
            int k=tmp[1];
            TreeNode cur = node.poll();
            if(!map.containsKey(i)) map.put(i,new ArrayList<>());
            map.get(i).add(new int[]{cur.val,k});
            if(cur.left!=null){
                idx.add(new int[]{i-1,k-1});
                node.add(cur.left);
                min = Math.min(min,i-1);
            }
            if(cur.right!=null){
                idx.add(new int[]{i+1,k-1});
                node.add(cur.right);
                max = Math.max(max,i+1);
            }
        }
        for(int j=min;j<=max;j++){
            Collections.sort(map.get(j),new cmp());
            List<Integer> lst = new ArrayList<>();
            for(int l=0;l<map.get(j).size();l++)
                lst.add(map.get(j).get(l)[0]);
            lol.add(lst);
        }
        return lol;
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        if(a[1]==b[1]) return a[0]-b[0];
        return b[1]-a[1];
    }
}