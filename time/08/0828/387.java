387. First Unique Character in a String
Easy

1254

89

Favorite

Share
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            else
                hm.put(s.charAt(i),1);
        
        }
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))==1) return i;
        }
        
        
        return -1;
    }
}