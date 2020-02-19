567. Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()==0||s1.length()==0) return false;
        
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i=0;i<s1.length();i++){
            if(!hm.containsKey(s1.charAt(i)))
            hm.put(s1.charAt(i),1);
            else
                hm.put(s1.charAt(i),hm.get(s1.charAt(i))+1);
        }
        int counter=hm.size();
        int left=0;
        int right=0;
        while(right<s2.length()){
            //System.out.println("@");
            if(hm.containsKey(s2.charAt(right))){
                hm.put(s2.charAt(right),hm.get(s2.charAt(right))-1);
                if(hm.get(s2.charAt(right))==0){
                    counter--;
                }
            }
            while(counter==0){
               if(right-left+1==s1.length())
                    return true;
               if(hm.containsKey(s2.charAt(left))){
                    if(hm.get(s2.charAt(left))==0){
                    counter++;
                }
                   hm.put(s2.charAt(left),hm.get(s2.charAt(left))+1);
                
                 }
                left++;
            }
            right++;
        }
        return false;
    }
}