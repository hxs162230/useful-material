211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

class WordDictionary {
    class Trie{
        private int r=26;
        private String item;
        private Trie[] child;
        public Trie(){
            child = new Trie[26];
            item="";
        }
        public String getItem(){
            return item;
        }
        public Trie getChild(int i){
            if (i >= 26 || i < 0) throw new IllegalArgumentException();
            return child[i];
        }
        public Trie[] getChildren(){
            return child;
        }
        public void setItem(String item){
            this.item=item;
        }
        public void setChild(int i,Trie node){
            child[i]=node;
        }
        
    }
    /** Initialize your data structure here. */
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.getChild(ch-'a')==null){
                cur.setChild(ch-'a',new Trie());
            }
            cur = cur.getChild(ch-'a');
        }
        cur.setItem(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word,root,0);
    }
    public boolean searchWord(String word,Trie cur,int i){
        if(i==word.length()) return !cur.getItem().equals("");
        if(word.charAt(i)=='.'){
            for(int idx=0;idx<26;idx++){
                
                if(cur.getChild(idx)!=null){
                    if(searchWord(word,cur.getChild(idx),i+1))
                        return true;
                }
            }
            return false;
        }
        else{
            return ((cur.getChild(word.charAt(i)-'a')!=null) && searchWord(word,cur.getChild(word.charAt(i)-'a'),i+1));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */