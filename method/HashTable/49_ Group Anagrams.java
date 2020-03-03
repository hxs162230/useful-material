49. Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

T:O(N*n == Number of character)
S:O(N)
HashMap查找

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            int[] alpha = new int[26];
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length();i++){
                alpha[str.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                sb.append(String.valueOf(alpha[i]));
            }
            String s = sb.toString();
            map.putIfAbsent(s,new ArrayList<String>());
            map.get(s).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}