96. Unique Binary Search Trees

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

就跟斐波那契数列一样，我们把 n = 0 时赋为1，因为空树也算一种二叉搜索树，

那么 n = 1 时的情况可以看做是其左子树个数乘以右子树的个数，左右子树都是空树，

所以1乘1还是1。那么 n = 2 时，由于1和2都可以为根，分别算出来，再把它们加起来即可。

n = 2 的情况可由下面式子算出（这里的 dp[i] 表示当有i个数字能组成的 BST 的个数）：

dp[2] =  dp[0] * dp[1]　　　(1为根的情况，则左子树一定不存在，右子树可以有一个数字)

　　　　+ dp[1] * dp[0]　　  (2为根的情况，则左子树可以有一个数字，右子树一定不存在)

同理可写出 n = 3 的计算方法：

dp[3] =  dp[0] * dp[2]　　　(1为根的情况，则左子树一定不存在，右子树可以有两个数字)

　　　　+ dp[1] * dp[1]　　  (2为根的情况，则左右子树都可以各有一个数字)

 　　　  + dp[2] * dp[0]　　  (3为根的情况，则左子树可以有两个数字，右子树一定不存在)


我们根据以上的分析，可以写出代码如下：

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        int cnt=0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            } 
        }
        return dp[n];
    }
}