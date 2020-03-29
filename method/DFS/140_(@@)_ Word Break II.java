140. Word Break II
Hard

1262

285

Favorite

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
T:O(2^N)

class Solution {
   // private HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        HashMap<String,List<String>> memo=new HashMap<>();
        return wordSep(set,s,memo);
    }
    public List<String> wordSep(HashSet<String> set,String s,HashMap<String,List<String>> memo){
        List<String> ans=new ArrayList<>();
        if(memo.containsKey(s)){
           return memo.get(s);
        }
        if(set.contains(s)){
            ans.add(s); //不return
        }
        for(int i=1;i<s.length();i++){
            String right=s.substring(i);
            if(set.contains(right)){
                List<String> left = wordSep(set,s.substring(0,i),memo);
                for(int j=0;j<left.size();j++){
                    ans.add(left.get(j)+" "+right);
                }
            }
        }
        memo.put(s,ans);
        return ans;
    }
}