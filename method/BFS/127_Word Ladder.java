127. Word Ladder
Medium

2366

978

Add to List

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. 

Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


T:O(N) N=word.length;
S:O(N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int lv=0;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                String word = q.poll();
                if(word.equals(endWord))     return lv+1; // include beginword 所以加上 1
                char[] transWord = word.toCharArray();
                for(int j=0;j<word.length();j++){
                    for(char c='a';c<='z';c++){
                        if(transWord[j]==c) continue;
                        char oldChar = transWord[j];
                        transWord[j]=c;
                        if(set.contains(String.valueOf(transWord))){
                            set.remove(String.valueOf(transWord));
                            q.add(String.valueOf(transWord));
                        }
                        transWord[j]=oldChar;
                    }
                }
            }
            lv++;
        }
        return 0;
    }
}



Bi-direction bfs
time O(N/2)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        //dict.add(beginWord);
        if(!dict.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        int step = 0;
        while(!q1.isEmpty()&&!q2.isEmpty()){
            ++step;
            if(q1.size()>q2.size()){
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            Set<String> nextSet = new HashSet<>();
            for(String curStr:q1){
                char[] curArr = curStr.toCharArray();
                for(int i=0;i<curArr.length;i++){
                    for(char c='a';c<='z';c++){
                        if(curArr[i]==c) continue;
                        char old = curArr[i];   
                        curArr[i] = c;
                        String nextStr = String.valueOf(curArr);
                        if(q2.contains(nextStr)) return step+1;
                        if(dict.contains(nextStr)){
                            dict.remove(nextStr);
                            nextSet.add(nextStr);
                        }
                        curArr[i] = old;
                    }
                }
            }
            q1 = nextSet;
        }
        return 0;
    }   
}