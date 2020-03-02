242. Valid Anagram
Easy

919

121

Favorite

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map= new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
            map.put(s.charAt(i),1);
            else
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i))==0) 
                    map.remove(t.charAt(i));
                }
            else 
                return false;
        }
         return map.isEmpty();
    }
}