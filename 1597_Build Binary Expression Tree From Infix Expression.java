1597. Build Binary Expression Tree From Infix Expression
Hard

42

12

Add to List

Share
A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with 2 children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

For each internal node with operator o, the infix expression that it represents is (A o B), where A is the expression the left subtree represents and B is the expression the right subtree represents.

You are given a string s, an infix expression containing operands, the operators described above, and parentheses '(' and ')'.

Return any valid binary expression tree, which its in-order traversal reproduces s after omitting the parenthesis from it (see examples below).

Please note that order of operations applies in s. That is, expressions in parentheses are evaluated first, and multiplication and division happen before addition and subtraction.

Operands must also appear in the same order in both s and the in-order traversal of the tree.

 

Example 1:



Input: s = "2-3/(5*2)+1"
Output: [+,-,1,2,/,null,null,null,null,3,*,null,null,5,2]
Explanation: The inorder traversal of the tree above is 2-3/5*2+1 which is the same as s without the parenthesis. The tree also produces the correct result and its operands are in the same order as they appear in s.
The tree below is also a valid binary expression tree with the same inorder traversal as s:

The third tree below however is not valid. Although it produces the same result and is equivalent to the above trees, its inorder traversal doesn't produce s and its operands are not in the same order as s.

Example 2:



Input: s = "3*4-2*5"
Output: [-,*,*,3,4,2,5]
Explanation: The tree above is the only valid tree whose inorder traversal produces s.
Example 3:

Input: s = "1+2+3+4+5"
Output: [+,+,5,+,4,null,null,+,3,null,null,1,2]
Explanation: The tree [+,+,5,+,+,null,null,1,2,3,4] is also one of many other valid trees.
 

Constraints:

1 <= s.length <= 105
s consists of digits and the characters '+', '-', '*', '/', '(', and ')'.
Operands in s are exactly 1 digit.
It is guaranteed that s is a valid expression.


/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        //infix to postfix 
        Queue<Character> postfixQ = infixToPostfix(s);
        
        Node tree = createTree(postfixQ);
        
        return tree;
        
    }
    public Node createTree(Queue<Character> q){
        Stack<Node> stk = new Stack<>();
        
        for(char c : q){
            if(isOp(c)){
                Node right = stk.pop();
                Node left = stk.pop();
                Node root = new Node(c);
                root.left = left;
                root.right = right;
                stk.push(root);
            }
            else{
                stk.push(new Node(c));
            }
        }
        
        return stk.peek();
    }
    public Queue<Character> infixToPostfix(String s){
        Queue<Character> postfixQ = new LinkedList<>();
        Stack<Character> operator = new Stack<>();
        for(char c:s.toCharArray()){
            if(c-'0'>=0&&c-'9'<=0){
                postfixQ.add(c);
            }
            else if(isOp(c)){
                while(!operator.isEmpty()&&switcher(operator.peek())>=switcher(c))
                    postfixQ.add(operator.pop());
                
                operator.push(c);
            }
            else if(c=='('){
                operator.push(c);
            }
            else{
                while(!operator.isEmpty()&&operator.peek()!='(')
                    postfixQ.add(operator.pop());
                
                operator.pop();
            }
        }
        
        while(!operator.isEmpty())
                postfixQ.add(operator.pop());
        
        for(char k:postfixQ){
            System.out.print(k+" ");
        }
        return postfixQ;
    }
    public boolean isOp(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
    public int switcher(char c){
        if(c=='+'||c=='-'){
            return 0;
        }
        else if(c=='*'){
            return 1;
        }
        else if(c=='/')
            return 2;
        else return -1;
    }
}