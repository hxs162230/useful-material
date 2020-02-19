395. Longest Substring with At Least K Repeating Characters

Find the length of the longest substring T of a given string (consists of lowercase letters only) 

such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

因为题目中限定了字符串中只有字母，这意味着最多不同的字母数只有 26 个，
最后满足题意的子串中的不同字母数一定是在 [1, 26] 的范围，这样就可以遍历这个范围，
每次只找不同字母个数为 cnt，
且每个字母至少重复k次的子串，来更新最终结果 res。这里让 cnt 从1遍历到 26，对于每个 cnt，都新建一个大小为 26 的数组 charCnt 
来记录每个字母的出现次数，使用的思想其实还是滑动窗口 Sliding Window，使用两个变量 start 和 i 来分别标记窗口的左右边界，
当右边界小于n时，进行 while 循环，需要一个变量 valid 来表示当前子串是否满足题意，初始化为 true，还需要一个变量 uniqueCnt 
来记录子串中不同字母的个数。此时若 s[i] 这个字母在 charCnt 中的出现次数为0，说明遇到新字母了，uniqueCnt 自增1，同时把该字母的映射值加1。
此时由于 uniqueCnt 变大了，有可能会超过之前限定了 cnt，所以这里用一个 while 循环，条件是当 uniqueCnt 大于 cnt ，
此时应该收缩滑动窗口的左边界，那么对应的左边界上的字母的映射值要自减1，若减完后为0了，则 uniqueCnt 自减1，注意这里一会后加，一
会先减的操作，不要搞晕了。当 uniqueCnt 没超过 cnt 的时候，此时还要看当前窗口中的每个字母的出现次数是否都大于等于k，遇到小于k的字母，
则直接 valid 标记为 false 即可。最终若 valid 还是 true，则表示滑动窗口内的字符串是符合题意的，用其长度来更新结果 res 即可，参见代码如下：

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int max=0;
        for(int i=1;i<=26;i++){
            int uniqueCnt = 0;
            int[] cnt = new int[26];
            int right=0;
            int left=0;
            while(right<n){
                boolean valid = true;
                if(cnt[s.charAt(right)-'a']++==0) uniqueCnt++;
                while(left<right && uniqueCnt>i){
                    if(--cnt[s.charAt(left)-'a']==0) uniqueCnt--;
                    left++;
                }
                for(int j=0;j<26;j++){
                    if(cnt[j]<k&&cnt[j]>0) valid=false; //至少>=k才valid
                }
                if(valid) max = Math.max(max,right-left+1);
                right++;
            }
        }
        return max;
    }
}