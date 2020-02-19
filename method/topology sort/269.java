269. Alien Dictionary

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.


T:I guess it should be O(V+E) in topological sort part. Each node is pushed into queue once, and each edge is checked exactly once.
S:O(V+E)

class Solution {
    int[] indegree = new int[26];
    HashMap<Character,Set<Character>> map = new HashMap<>();
    public String alienOrder(String[] words) {
        buildgraph(words);
        return bfs();
    }
    public void buildgraph(String[] words){
        for(String word:words){
            for(char c:word.toCharArray()){
                map.putIfAbsent(c,new HashSet<>());
            }
        }
        for(int i=1;i<words.length;i++){
            String fst = words[i-1];
            String sec = words[i];
            int len = Math.min(fst.length(),sec.length());
                for(int j=0;j<len;j++){
                    if(fst.charAt(j)!=sec.charAt(j)){
                        char out = fst.charAt(j);
                        char in = sec.charAt(j);
                        if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        indegree[in-'a']++;
                        }
                        break;
                    }
                
                }
        }
    }
    public String bfs(){
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char c:map.keySet()){
            if(indegree[c-'a']==0){
                q.add(c);
                sb.append(c);
            }
        }
        while(!q.isEmpty()){
            char out = q.poll();
            for(char in:map.get(out)){
                indegree[in-'a']--;
                if(indegree[in-'a']==0){
                    q.add(in);
                    sb.append(in);
                }
            }
        }
        return sb.length()==map.size()?sb.toString():"";
    }
}