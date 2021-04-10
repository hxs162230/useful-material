763. Partition Labels
Medium

1344

74

Favorite

Share
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

那么这道题的难点就是如何找到字符串的断点，即拆分成为子串的位置。
我们仔细观察题目中的例子，可以发现一旦某个字母多次出现了，
那么其最后一个出现位置必须要在当前子串中，字母a，e，和j，
分别是三个子串中的结束字母。所以我们关注的是每个字母最后的出现位置，
我们可以使用一个 HashMap 来建立字母和其最后出现位置之间的映射，
那么对于题目中的例子来说，我们可以得到如下映射：

!找斷開位置

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            map.put(ch,i);
        }
        int last=0;
        int start=0;
        for(int i=0;i<S.length();i++){
            last = Math.max(last,map.get(S.charAt(i)));
            if(last==i){
                res.add(last-start+1);
                start=i+1;
            }
        }
        return res;
    }
}