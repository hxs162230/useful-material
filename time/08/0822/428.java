/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        se(root,sb);
        return sb.toString().substring(1);
    }
    public void se(Node root,StringBuilder sb){
        sb.append(",");
        if(root==null){
            sb.append("null");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(root.children.size());
        for(Node node:root.children){
            se(node,sb);    
        }
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] str = data.split(",");
        int[] idx={-1};
        return de(str,idx);
        
    }
    public Node de(String[] str,int[] idx){
        idx[0]++;
        if(str[idx[0]].equals("null")){
            return null;
        }
        int val = Integer.parseInt(str[idx[0]++]);
        int numOfchild= Integer.parseInt(str[idx[0]]);
        Node node=new Node(val,new ArrayList<Node>());
    
        for(int i=0;i<numOfchild;i++){
            node.children.add(de(str,idx));
        }
        return node;
            
    }
}
