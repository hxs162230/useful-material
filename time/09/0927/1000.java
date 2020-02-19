1000. Minimum Cost to Merge Stones

There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

A move consists of merging exactly K consecutive piles into one pile, 

and the cost of this move is equal to the total number of stones in these K piles.

Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.

Example 1:

Input: stones = [3,2,4,1], K = 2
Output: 20
Explanation: 
We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 20, and this is the minimum possible.
Example 2:

Input: stones = [3,2,4,1], K = 3
Output: -1
Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
Example 3:

Input: stones = [3,5,1,2,6], K = 3
Output: 25
Explanation: 
We start with [3, 5, 1, 2, 6].
We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
We merge [3, 8, 6] for a cost of 17, and we are left with [17].
The total cost was 25, and this is the minimum possible.
 

Note:

1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100


这道题给了我们N堆石头，每堆石头有不同的个数，说每次可以合并K堆石头，合并堆的花费就是石头的个数，
然后问如何合并，才能使总花费最小。然后给了一些例子，通过观察例子，可以发现，
并不是所有的输入都能成功合成一堆，比如例子2，无论先和并哪三堆，最终都会剩下两堆，
从而无法进一步合并，因为 K=3，每次至少需要合并三堆。我们当然希望能在开始合并之前就能知道最终是否能成功合并为一堆，
而不是算到最后了才发现白忙了一场，所以要来分析一下，什么时候才能最终合并为一堆。
再来看看例子2，每次要将三堆合并为一堆，那么就是减少了两堆，而要使得最终能够剩下一堆，
其他的都要合并调，那么假设原来共有n堆，只能剩下一堆，就是说 n-1 堆都要减掉，而每次只能减少 k-1 堆，
所以只要 n-1 能够整除 k-1即可，即 (n-1)%(k-1) == 0 成立，这样我们就可以提前判断了。

好，接下来继续，考虑如何来解题，首先要意识到这道题的情况可能非常多，用暴力搜索的话可能会非常的复杂，
而且当前的合并方法完全会影响到之后的合并，所以基本是要放弃 Brute force 的想法的。
同样，这道题也不能用贪婪算法，每次都合并石子个数最少的三堆会收敛到局部峰值，
不一定是全局的，所以只能另辟蹊径。观察到这题是玩数组的，又是求极值的题目，
那么就要祭出神器动态规划 Dynamic Programming 了，
那么先来考虑定义dp数组吧，那么最简单直接的方法肯定直接用个二维的dp数组了，
其中 dp[i][j] 表示合并范围 [i, j] 内的石头堆的最小花费，那么最终 dp[0][n-1] 就是所要求的值。
看到了论坛上有人定义了三维的 dp 数组，把每次合并的堆数K也当作一维放入到 dp 数组中了，
其实博主觉得不是很有必要，因为像这种必须要对 dp 数组进行升维操作的是当题目中有隐藏信息
 Hidden Information，而当前定义的 dp 数组无法重现子问题，即无法找到状态转移方程的时候必须要做的，
 最典型的例子就是之前那道 Remove Boxes，那道题自区间的dp值非常依赖于区间左边相同的数字的个数，
 而这道题每次合并的堆数K并不是很依赖其他小于K的合并的堆数，所以博主感觉没有必要加。关于含有隐藏信息的 dp 
 题目，博主感觉巅峰就属于拣樱桃那题 Cherry Pickup 了吧，现在看还是有点晕，改天还得重新加工一下吧。
 其实跟这道题最像的当属于打气球那题 Burst Balloons，气球爆了之后，两边的气球就挨到一起了，这里也很类似，
 石子合并之后，再跟两边的石子堆继续合并，这里的更新方式还是从小区间更新到大区间，
 跟打气球那题的思路非常的相似，建议先去看看博主的之前那篇博客 Burst Balloons，会对理解这道题大有裨益。

根据之前打气球的经验，我们要从小区间开始更新，多小呢，从K开始，因为小于K的区间不用更新，其 dp 值一定为0，
因为每次必须合并K堆石子，所以区间的长度 len 从K遍历到 n。好，区间长度确定了，
现在要确定起点了，i从0遍历到 n-len 即可，有了区间的起点和长度，可以确定区间的终点 j = i+len-1。
我们的目标就是要更新区间 [i, j] 的dp值，先初始化为整型最大值。接下来的更新方法，
即状态转移方程，就是本题最大的难点了，要求区间 [i, j] 的 dp 值，没法直接得到，
但是由于是从小区间开始更新的，所以 suppose 其中的小区间的 dp 值，我们都已经更新好了，
那么就可以将大区间拆成两个小区间来更新了。一般来讲，将一个数组拆成两个非空子数组的时候，
会遍历其所有情况，比如 [1, 2, 3, 4]，会拆成 [1] 和 [2,3,4]，[1,2] 和 [3,4], [1,2,3] 和 [4]。
但是这道题由于其特殊性，并不需要遍历所有的拆分情况，因为某些区间是无法通过合并石子堆得到的，
就拿上面的例子来说，若 K=3，那么就不需要用 [1,2] 和 [3,4] 来更新整个区间，它们都不到3个，无法合并，
所以我们遍历的时候每次跳过 K-1 个位置即可，用 t 来分别区间 [i, j]，然后每次 t += K-1 即可，
用两个小区间的dp值来更新整个区间。这还没有完，当某个子区间正好可以合并为一堆石子的时候，
其 dp 值要加上该区间所有的石子数。举个最简单的例子，比如 [1, 2, 3]，K=3，那么我们分割的话，
只能用 dp[0][0] + dp[1][2] 来更新 dp[0][1]，但是 dp[0][0] 和 dp[1][2] 均为0，
因为区间长度均小于3，那么我们的 dp[0][2] 值就无法更新成正确的值了，这三个数字是可以合并的，
所以要加上区间内所有的数字之和，而为了快速的求得任意区间和，采用提前建立累加和数组sums的方式，
来提高计算效率，所以整个状态转移方程为：

dp[i][j] = min(dp[i][j], dp[i][t] + dp[t + 1][j]); -> (i <= t < j)

dp[i][j] += sums[j + 1] - sums[i]; -> if ((j - i) % (K - 1) == 0)

有了状态转移方程，我们就可以写出代码如下：
class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if((n-1)%(K-1)>0) return -1;
        int[][] dp = new int[n][n];
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+stones[i-1];
        }
        for(int len=K;len<=n;len++){
            for(int i=0;i<=n-len+1-1;i++){ //<-boundary condition figure out; dp[i][]從0開始計算 
                int j=i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k+=K-1){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]);
                }
                if((j-i)%(K-1)==0){
                    dp[i][j] += sum[j+1]-sum[i];
                }
            }
        }
        return dp[0][n-1];
    }
}