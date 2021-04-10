161. One Edit Distance

Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.


class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if(Math.abs(slen-tlen)>=2) return false;
        if(Math.abs(slen-tlen)==1){
            if(slen==0||tlen==0) return true;
            if(slen<tlen){
                for(int i=0;i<slen;i++){   //insert to s
                     if(s.charAt(i)!=t.charAt(i)){
                        return t.substring(i+1).equals(s.substring(i));
                    }       
                }
                return true;
            }
            else{
                for(int i=0;i<tlen;i++){  //delete from s
                    if(s.charAt(i)!=t.charAt(i)){
                        return t.substring(i).equals(s.substring(i+1));
                    }       
                }
                return true;
            }
        }
        else{
            int match=0;
            for(int i=0;i<slen;i++){
                if(match>1) return false;
                if(s.charAt(i)!=t.charAt(i))
                    match++;
            }
            return match==1;
        }
    }
}