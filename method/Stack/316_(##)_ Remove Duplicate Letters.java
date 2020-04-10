316. Remove Duplicate Letters

Given a string which contains only lowercase letters, 

remove duplicate letters so that every letter appears once and only once. 

You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"


这道题让我们移除重复字母，使得每个字符只能出现一次，而且结果要按字母顺序排，
前提是不能打乱其原本的相对位置。我们的解题思路是：先建立一个哈希表来统计每个字母出现的次数，
还需要一个visited数字来纪录每个字母是否被访问过，我们遍历整个字符串，对于遍历到的字符，
先在哈希表中将其值减一，然后看visited中是否被访问过，若访问过则继续循环，
说明该字母已经出现在结果中并且位置已经安排妥当。如果没访问过，我们和结果中最后一个字母比较，
如果该字母的ASCII码小并且结果中的最后一个字母在哈希表中的值不为0(说明后面还会出现这个字母)，
那么我们此时就要在结果中删去最后一个字母且将其标记为未访问，然后加上当前遍历到的字母，并且将其标记为已访问，
以此类推直至遍历完整个字符串s，此时结果里的字符串即为所求。这里有个小技巧，
我们一开始给结果字符串res中放个"0"，就是为了在第一次比较时方便，如果为空就没法和res中的最后一个字符比较了，
而‘0’的ASCII码要小于任意一个字母的，所以不会有问题。最后我们返回结果时再去掉开头那个‘0’即可，
参见代码如下：

T:O(26*N)

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder("0");
        boolean[] visit = new boolean[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            alpha[c-'a']--;
            if(visit[c-'a']) continue;
            while(c<sb.charAt(sb.length()-1)&&alpha[sb.charAt(sb.length()-1)-'a']>0){
                visit[sb.charAt(sb.length()-1)-'a'] = false;
                sb.setLength(sb.length()-1);
            }
            visit[c-'a'] = true;
            sb.append(c);
        }
        return sb.toString().substring(1);
    }
}