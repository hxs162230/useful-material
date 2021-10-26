676. Implement Magic Dictionary
Medium

582

134

Add to List

Share
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.


O(26^len) for time 


class MagicDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String d:dict){
            addWord(d,root);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(word,0,root,0);
    }
    public boolean dfs(String s,int idx,Trie cur,int miss){
        if(s==null||s.length()==0) return false;
        
        //purning 
        if(miss>1) return false;
        if(idx==s.length()) return miss==1&&cur.isWord==true;
        
        
        for(int i=0;i<26;i++){
            char c = s.charAt(idx);
            if(cur.child[i]!=null){
                if(c-'a'!=i){
                    if(dfs(s,idx+1,cur.child[i],miss+1)) return true;
                }else{
                    if(dfs(s,idx+1,cur.child[i],miss)) return true;
                }
            }
        }
        return false;
    }
    public void addWord(String s,Trie cur){
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(cur.child[c-'a']==null){
                cur.child[c-'a'] = new Trie();
            }    
            cur = cur.child[c-'a'];
        }
        cur.isWord = true;
    }
    class Trie{
        boolean isWord;
        Trie[] child;
        public Trie(){
            this.isWord = false;
            this.child = new Trie[26];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */