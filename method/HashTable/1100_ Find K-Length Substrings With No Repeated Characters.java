1100. Find K-Length Substrings With No Repeated Characters

Share
Given a string S, return the number of substrings of length K with no repeated characters.

 

Example 1:

Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
Example 2:

Input: S = "home", K = 5
Output: 0
Explanation: 
Notice K can be larger than the length of S. In this case is not possible to find any substring.
 

Note:

1 <= S.length <= 10^4
All characters of S are lowercase English letters.
1 <= K <= 10^4


class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int cnt =0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0,j=0;i<S.length();i++){
           while(set.contains(S.charAt(i))){
               set.remove(S.charAt(j++));
           }
            set.add(S.charAt(i));
            cnt+=i-j+1>=K?1:0;
        }
        return cnt;
    }
}


LC#3
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int cnt =0;
        if(K>S.length()) return 0;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            if(map.containsKey(S.charAt(i))){
                left = Math.max(left,map.get(S.charAt(i))+1);
            }
            map.put(S.charAt(i),i);
            cnt+=i-left+1>=K?1:0;
        }
        return cnt;
    }
}