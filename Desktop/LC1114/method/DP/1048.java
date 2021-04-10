1048. Longest String Chain
Medium

268

19

Favorite

Share
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
 

Note:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
 


Sort the words by word's length. (also can apply bucket sort)
For each word, loop on all possible previous word with 1 letter missing.
If we have seen this previous word, update the longest chain for the current word.
Finally return the longest word chain.


LC#300


class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,new cmp());
        HashMap<String,Integer> dp = new HashMap<>();
        int globalmax=0;
        for(String word:words){
            int max=0;
            for(int i=0;i<word.length();i++){
                String s = word.substring(0,i)+word.substring(i+1);
                max = Math.max(max,dp.getOrDefault(s,0)+1); 
            }
            dp.put(word,max);
            globalmax = Math.max(globalmax,max);
        }
        return globalmax;
    }
}
class cmp implements Comparator<String>{
    public int compare(String a,String b){
        return a.length()-b.length();
    }
}