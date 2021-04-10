76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

T:O(N)
S:O(N)
sliding window 
在內層迴圈 => valid狀態 


class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                map.put(t.charAt(i),1);
            else
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
        }
        int var=map.size();
        int left=0;
        int right=0;
        int mlen=s.length()+1;
        int mleft=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right))==0) var--;
            }
            while(var==0){
                if(right-left+1<mlen){
                    mlen=right-left+1;
                    mleft=left;
                }
                if(map.containsKey(s.charAt(left))){
                    if(map.get(s.charAt(left))==0) var++;
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                }
                left++;
            }
            right++;
        }
        return mlen>s.length()?"":s.substring(mleft,mleft+mlen);
        
    }
}