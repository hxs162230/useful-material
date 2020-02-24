844. Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

这道题的 follow up 让我们使用常数级的空间复杂度，就是说不能新建空的字符串来保存处理之后的结果，
那么只能在遍历的过程中同时进行比较，只能使用双指针同时遍历S和T串了。我们采用从后往前遍历，
因为退格是要删除前面的字符，所以倒序遍历要好一些。

用变量i和j分别指向S和T串的最后一个字符的位置，
然后还需要两个变量 cnt1 和 cnt2 来分别记录S和T串遍历过程中连续出现的井号的个数，因为在连续井号后，
要连续删除前面的字母，如何知道当前的字母是否是需要删除，就要知道当前还没处理的退格符的个数。好，
现在进行 while 循环，条件是i和j至少有一个要大于等于0，然后对S串进行另一个 while 循环，条件是当i大于等于0，
且当前字符是井号，或者 cnt1 大于0，若当前字符是退格符，则 cnt1 自增1，否则 cnt1 自减1，然后i自减1，
这样就相当于跳过了当前的字符，不用进行比较。对T串也是做同样的 while 循环处理。之后若i和j有一个小于0了，
那么可以根据i和j是否相等的情况进行返回。否则再看若S和T串当前的字母不相等，则返回 false，
因为当前位置的退格符已经处理完了，剩下的字母是需要比较相等的，
若不相等就可以直接返回 false 了。最后当外层的 while 循环退出后，返回i和j是否相等，参见代码如下：

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int m = S.length();
        int n = T.length();
        int i = m-1;
        int j = n-1;
        int cnt1=0;
        int cnt2=0;
        while(i>=0||j>=0){
            while(i>=0&&(S.charAt(i)=='#'||cnt1>0)) cnt1+=(S.charAt(i--)=='#')?1:-1;
            while(j>=0&&(T.charAt(j)=='#'||cnt2>0)) cnt2+=(T.charAt(j--)=='#')?1:-1;
            if(i<0||j<0) return i==j;
            if(S.charAt(i--)!=T.charAt(j--)) return false; 
        }
        return i==j;
    }
}