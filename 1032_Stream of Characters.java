1032. Stream of Characters
Hard

284

55

Add to List

Share
Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.


class StreamChecker {
    class Trie{
        Trie[] child;
        boolean isWord;
        public Trie(){
            child = new Trie[26];
            isWord = false;
        }
    }
    Trie root;
    StringBuilder prefix;
    public StreamChecker(String[] words) {
        prefix = new StringBuilder();
        root = new Trie();
        //if(words.length==0) return;
        for(String word:words){
            Trie cur = root;
            addWord(word,cur);
        }
    }
    public void addWord(String word,Trie cur){
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(cur.child[c-'a']==null){
                cur.child[c-'a'] = new Trie();
            }
            cur = cur.child[c-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean query(char letter) {
        prefix.append(letter);
        Trie cur = root;
        if(search(prefix.toString(),cur)) return true;
        else return false;
    }
    public boolean search(String s,Trie cur){
        for(int i=s.length()-1;i>=0&&cur!=null;i--){
            char c = s.charAt(i);
            cur = cur.child[c-'a'];
            if(cur!=null&&cur.isWord){
                return true;
            }  
        }
        return false;
    }
}
