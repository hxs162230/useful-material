30. Substring with Concatenation of All Words
Hard

661

1037

Favorite

Share
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []

T:O(N*num)


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        List<Integer> lst=new ArrayList<>();
        if (s.length()<=0 || words.length == 0 || words[0].length() == 0) return lst;
        int len=words[0].length();
        for(String s1:words){
            if(!hm.containsKey(s1))
            hm.put(s1,1);
            else
            hm.put(s1,hm.get(s1)+1);
        }
        for(int i=0;i<=s.length()-len*words.length;i++){
            Map<String, Integer> copy = new HashMap<String, Integer>(hm);
            for(int j=0;j<words.length;j++){
                String str=s.substring(i+j*len,i+j*len+len); //nextword
                //System.out.println(str);
                if(copy.containsKey(str)){
                        copy.put(str,copy.get(str)-1);
                    if(copy.get(str)==0)
                        copy.remove(str);
                    if(copy.isEmpty()){
                       // System.out.println(str);
                        lst.add(i);
                        break;
                    }      
                }
                else
                break;
            }
        }
        return lst;
    }
}