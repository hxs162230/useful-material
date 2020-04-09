249. Group Shifted Strings
Medium

387

72

Add to List

Share
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Accepted
61,177
Submissions
117,893


class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //a  z==b  a
        //0 25==0 -1
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strings){
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<len;i++){    
                int k = (s.charAt(i)-s.charAt(0)+26)%26;
                sb.append(k);
                sb.append("@");
            }
        
            map.putIfAbsent(sb.toString(),new ArrayList<>());
            map.get(sb.toString()).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}