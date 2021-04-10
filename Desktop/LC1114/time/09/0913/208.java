208. Implement Trie (Prefix Tree)
Medium

2007

36

Favorite

Share
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.


class Tnode {
    private int r=26;
    private Tnode[] children;
    private String item;
    public Tnode(){
        children = new Tnode[r];
        item="";
    }
     public String getItem() {
        return item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }
    
    public Tnode[] getChildren() {
        return children;
    }
    
    public Tnode getChild(int i) {
        if (i >= 26 || i < 0) throw new IllegalArgumentException();
        return children[i];
    }
    
    public void setChild(int i, Tnode node) {
        children[i] = node;
    }
    
}


class Trie {
    Tnode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new Tnode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Tnode cur =root;
        for(int i=0;i<word.length();i++){
        if(cur.getChild(word.charAt(i)-'a')==null)  
            cur.setChild(word.charAt(i)-'a',new Tnode());
            cur=cur.getChild(word.charAt(i)-'a');
        }
        cur.setItem(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Tnode cur=root;
        for(int i=0;i<word.length();i++){
            if(cur.getChild(word.charAt(i)-'a')==null) return false;
            cur=cur.getChild(word.charAt(i)-'a');
            
        }
        return (cur.getItem().equals(word)) ;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Tnode cur=root;
        for(int i=0;i<prefix.length();i++){
            if(cur.getChild(prefix.charAt(i)-'a')==null) return false;
            cur=cur.getChild(prefix.charAt(i)-'a');
            
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */