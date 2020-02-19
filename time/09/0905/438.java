438. Find All Anagrams in a String
Medium

1930

148

Favorite

Share
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

T:O(N)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        List<Integer> lst=new LinkedList<>();
        for(int i=0;i<p.length();i++){
            if(!hm.containsKey(p.charAt(i))){
                hm.put(p.charAt(i),1);
            }
            else
                hm.put(p.charAt(i),hm.get(p.charAt(i))+1);    
        }
        int counter=hm.size();
        int left=0;
        int right=0;
        while(right<s.length()){
            if(hm.containsKey(s.charAt(right))){
                hm.put(s.charAt(right),hm.get(s.charAt(right))-1);
                if(hm.get(s.charAt(right))==0)
                    counter--;
            }
            while(counter==0){
                if(right-left+1==p.length()){
                    lst.add(left);
                }
                if(hm.containsKey(s.charAt(left))){
                
                if(hm.get(s.charAt(left))==0)
                    counter++;
                hm.put(s.charAt(left),hm.get(s.charAt(left))+1);
                }
             left++;   
            }
            right++;
        }
        return lst;
    }
}