95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
这道题是之前的 Unique Binary Search Trees 的延伸，
之前那个只要求算出所有不同的二叉搜索树的个数，这道题让把那些二叉树都建立出来。
这种建树问题一般来说都是用递归来解，这道题也不例外，划分左右子树，递归构造。
这个其实是用到了大名鼎鼎的分治法 Divide and Conquer，类似的题目还有之前的那道 
Different Ways to Add Parentheses 用的方法一样，用递归来解，划分左右两个子数组，
递归构造。刚开始时，我们将区间 [1, n] 当作一个整体，然后我们需要将其中的每个数字都当作根结点，其划分开了左右两个子区间，然后分别调用递归函数，会得到两个结点数组，接下来要做的就是从这两个数组中每次各取一个结点，
当作当前根结点的左右子结点，然后将根结点加入结果 res 数组中即可，参见代码如下：

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return recur(1,n);
    }
    public List<TreeNode> recur(int st,int ed){
        List<TreeNode> lst = new ArrayList<>();
        if(st>ed) {
            lst.add(null);
            return lst;
        }    
        
        for(int i=st;i<=ed;i++){
            List<TreeNode> left= recur(st,i-1);
            List<TreeNode> right= recur(i+1,ed);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    lst.add(root);
                }
            }
        }
        
        return lst;
    }
}

sol2 memorization
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
    HashMap<String,List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<>();
        return combinations(1,n);
    }
    public List<TreeNode> combinations(int st,int ed){
        List<TreeNode> lst = new ArrayList<>();
        if(cache.containsKey(String.valueOf(st)+"-"+String.valueOf(ed)))
            return cache.get(String.valueOf(st)+"-"+String.valueOf(ed));
        if(st>ed){
            lst.add(null);
            return lst;
        }
        for(int i=st;i<=ed;i++){
            List<TreeNode> left = combinations(st,i-1);
            List<TreeNode> right = combinations(i+1,ed);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    lst.add(root);
                }
            }
        }
        cache.put(String.valueOf(st)+"-"+String.valueOf(ed),lst);
        return lst;
    }
}