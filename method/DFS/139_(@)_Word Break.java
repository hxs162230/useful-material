139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


T:O(N*2^N) considering substring copying O(N) 每次2分法
S:O(N)

class Solution {
    HashSet<String> set;
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return recur(s);
    }
    public boolean recur(String s){
        if(map.containsKey(s)) return map.get(s);
        if(set.contains(s)) return true;
        for(int i=1;i<s.length();i++){
            boolean right=recur(s.substring(i));
            boolean left=recur(s.substring(0,i));
            if(right&&left){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}


class Solution {
    HashSet<String> dict;
    HashMap<String,Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        cache = new HashMap<>();
        return dfs(s);
    }
    public boolean dfs(String s){
        if(dict.contains(s)) return true;
        if(cache.containsKey(s)) return cache.get(s);
        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            if(dict.contains(left)){
                if(dfs(s.substring(i))){
                    cache.put(s,true);
                    return true;
                }
            }
        }
        cache.put(s,false);
        return false;
    }
}