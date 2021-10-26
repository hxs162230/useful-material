1490. Clone N-ary Tree
Medium

110

7

Add to List

Share
Given a root of an N-ary tree, return a deep copy (clone) of the tree.

Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

class Node {
    public int val;
    public List<Node> children;
}
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Follow up: Can your solution work for the graph problem?

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,null,3,2,4,null,5,6]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 

Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 10^4].


class Solution {
    public Node cloneTree(Node root) {
        if(root==null) return root;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        map.put(root,new Node(root.val));
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node next : cur.children){
                if(map.get(next)==null){
                    map.put(next,new Node(next.val));
                    q.add(next);
                }
                map.get(cur).children.add(map.get(next));
            }
        }
        return map.get(root);
    }
}


class Solution {
    public Node cloneTree(Node root) {
        if(root==null) return root;
        HashMap<Node,Node> map = new HashMap<>();
        map.put(root,new Node(root.val));
        dfs(root,map);
        return map.get(root);
    }
    public void dfs(Node cur,HashMap<Node,Node> map){
        if(cur.children.size()==0) return;
        
        for(Node next : cur.children){
            if(map.get(next)==null){
                map.put(next,new Node(next.val));
            }
            dfs(next,map);
            map.get(cur).children.add(map.get(next));
        }
    }
}