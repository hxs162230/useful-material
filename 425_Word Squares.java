425. Word Squares
Hard

683

44

Add to List

Share
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
class Solution {
    Trie root;
    public List<List<String>> wordSquares(String[] words) {
        this.root = new Trie();
        
        for(String w:words){
            addWord(w);
        }
        
        
        List<List<String>> ans = new ArrayList<>(); 
        
        List<String> build = new ArrayList<>();
        int len = words[0].length();
        for(String word:words){
            build.add(word);
            dfs(build,ans,len);
            build.remove(build.size()-1);
        }
        
        return ans;
    }
    
    public void dfs(List<String> build,List<List<String>> ans,int len){
        if(build.size()==len){
            ans.add(new ArrayList<>(build));
            return;
        }
        
        int idx = build.size();
        StringBuilder scanner = new StringBuilder();
        //System.out.println(idx);
        for(String b : build){
            //System.out.println(b+"  "+idx);
            scanner.append(b.charAt(idx));
        }
        //System.out.print(scanner.toString());
        HashSet<String> sets = findPrefix(scanner.toString());
        for(String set:sets){
            build.add(set);
            dfs(build,ans,len);
            build.remove(build.size()-1);
        }
        
    }
    
    public HashSet<String> findPrefix(String s){
        Trie cur = root;
        
        for(char c:s.toCharArray()){
            //System.out.print(c);
            if(cur.child[c-'a']==null)
                return new HashSet<>();
                
            cur = cur.child[c-'a'];
            
        }
        return cur.startWith;
    }
    
    public void addWord(String s){
        Trie cur = root;
        //StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child[c-'a'] = new Trie();
            }
            
            cur = cur.child[c-'a'];
            cur.startWith.add(s);
        }
        
    }
    class Trie{
        HashSet<String> startWith;
        Trie[] child; 
        public Trie(){
            child = new Trie[26];
            startWith = new HashSet<>();
        }
    }
}