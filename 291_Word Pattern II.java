291. Word Pattern II
Hard

478

32

Add to List

Share
Given a pattern and a string s, return true if s matches the pattern.

A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.

 

Example 1:

Input: pattern = "abab", s = "redblueredblue"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "red"
'b' -> "blue"
Example 2:

Input: pattern = "aaaa", s = "asdasdasdasd"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "asd"
Example 3:

Input: pattern = "abab", s = "asdasdasdasd"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "a"
'b' -> "sdasd"
Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
Example 4:

Input: pattern = "aabb", s = "xyzabcxzyabc"
Output: false
 

Constraints:

0 <= pattern.length <= 20
0 <= s.length <= 50
pattern and s consist of only lower-case English letters.

class Solution {
    HashMap<Character,String> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        return dfs(pattern,s);
    }
    
    public boolean dfs(String p,String s){
        if(p.isEmpty()) return s.isEmpty();
        if(!p.isEmpty()&&s.isEmpty()) return false;
        
        if(map.containsKey(p.charAt(0))){
            String cur = map.get(p.charAt(0));
            if(s.length()<cur.length()) return false;
            String next = s.substring(0,cur.length());
            if(!cur.equals(next)) return false;
            if(dfs(p.substring(1),s.substring(cur.length()))) return true;
            
        }
        else{
            for(int i=1;i<=s.length();i++){
               String cur = s.substring(0,i);
               if(!set.add(cur)) continue; 
               map.put(p.charAt(0),cur); 
               if(dfs(p.substring(1),s.substring(i))) return true;
               map.remove(p.charAt(0));
               set.remove(cur); 
            }
        }
        return false;
    }
}