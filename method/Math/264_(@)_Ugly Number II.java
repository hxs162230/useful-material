264. Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.


这道题是之前那道 Ugly Number 的拓展，这里让找到第n个丑陋数，还好题目中给了很多提示，
基本上相当于告诉我们解法了，根据提示中的信息，丑陋数序列可以拆分为下面3个子列表：

(1) 1x2,V  2x2, 2x2, 3x2, 3x2,V 4x2, 5x2...
(2) 1x3,  1x3,V 2x3, 2x3, 2x3,V 3x3, 3x3...
(3) 1x5,  1x5, 1x5, 1x5,V 2x5, 2x5, 2x5,V...
仔细观察上述三个列表，可以发现每个子列表都是一个丑陋数分别乘以 2，3，5，
而要求的丑陋数就是从已经生成的序列中取出来的，每次都从三个列表中取出当前最小的那个加入序列，请参见代码如下：

class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int[] arr =new int[n];
        arr[0]=1;
        int idx1=0,idx2=0,idx3=0;
        for(int i=1;i<n;i++){
            int tmp = Math.min(2*arr[idx1],Math.min(3*arr[idx2],5*arr[idx3]));
            if(tmp==2*arr[idx1]) idx1++;
            if(tmp==3*arr[idx2]) idx2++;
            if(tmp==5*arr[idx3]) idx3++;
            arr[i] = tmp;
            
            
        }
        return arr[n-1];
        
        
        
    }
}