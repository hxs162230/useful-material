这道题也可以使用带优化的 DFS 来做，
我们使用一个 HashSet，用来保存匹配失败的情况，
我们分别用变量i，j，和k来记录字符串 s1，s2，和 s3 
匹配到的位置，初始化的时候都传入0。在递归函数中，首先根据i和j，算出 key 值，
由于我们的 HashSet 中只能放一个数字，而我们要 encode 两个数字i和j，
所以通过用i乘以 s3 的长度再加上j来得到 key，此时我们看，如果 key 已经在集合中，
直接返回 false，因为集合中存的是无法匹配的情况。然后先来处理 corner case 的情况，
如果i等于 s1 的长度了，说明 s1 的字符都匹配完了，
此时 s2 剩下的字符和 s3 剩下的字符可以直接进行匹配了，
所以我们直接返回两者是否能匹配的 bool 值。同理，
如果j等于 s2 的长度了，说明 s2 的字符都匹配完了，
此时 s1 剩下的字符和 s3 剩下的字符可以直接进行匹配了，
所以我们直接返回两者是否能匹配的 bool 值。如果 s1 和 s2 都有剩余字符，
那么当 s1 的当前字符等于 s3 的当前字符，那么调用递归函数，注意i和k都加上1，
如果递归函数返回 true，则当前函数也返回 true；
还有一种情况是，当 s2 的当前字符等于 s3 的当前字符，那么调用递归函数，注意j和k都加上1，
如果递归函数返回 true，那么当前函数也返回 true。如果匹配失败了，
则将 key 加入集合中，并返回 false 即可，参见代码如下：

class Solution {
    HashSet<Integer> set;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m= s1.length();
        int n= s2.length();
        if(m+n!=s3.length()) return false;
        set = new HashSet<>();
        return dfs(s1,s2,0,0,0,s3);
    }
    public boolean dfs(String s1,String s2,int i,int j,int k,String s3){
        int idx=i*s3.length()+j;
        if(i==s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j==s2.length()) return s1.substring(i).equals(s3.substring(k));
        if(set.contains(idx)) return false;
        if((s1.charAt(i)==s3.charAt(k)&&dfs(s1,s2,i+1,j,k+1,s3))||
            (s2.charAt(j)==s3.charAt(k)&&dfs(s1,s2,i,j+1,k+1,s3))) return true;
     
        set.add(idx);
        return false;
        
    }
}