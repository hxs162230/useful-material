472. Concatenated Words

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
T:O(N*2^N)

class Solution {
    HashSet<String> dict;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>();
        List<String> lst = new ArrayList<>();
        for(String word:words) dict.add(word);
        for(String word:words){
            if(word.equals("")) continue;
            if(dfs(word,0,0)){
                lst.add(word);
            }
        }
        return lst;
    }
    public boolean dfs(String word,int start,int cnt){
        if(start>=word.length()&&cnt>=2) return true;
        
        for(int i=1;i<=word.length()-start;i++){
            String split = word.substring(start,start+i);
            if(dict.contains(split)&&dfs(word,start+i,cnt+1)){
                return true;
            }
        }
        return false;
    }
}
sol2:
class Solution {
    HashSet<String> dict = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String word:words) dict.add(word);
        List<String> lst = new ArrayList<>();
        for(String word:words){
            if(dfs(word,0)){
                lst.add(word);
            }
        }
        return lst;
    }
    public boolean dfs(String word,int cnt){
        if(word.length()==0 && cnt>=2) return true;
        for(int i=1;i<=word.length();i++){
            String pre = word.substring(0,i);
            if(dict.contains(pre) &&  dfs(word.substring(i),cnt+1))
                return true;
        }
        return false;
    }
}