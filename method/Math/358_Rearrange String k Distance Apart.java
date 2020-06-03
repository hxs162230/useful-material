358. Rearrange String k Distance Apart
Hard

411

18

Add to List

Share
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".


Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.


similar to #767  case k = 2

time O(NlogN)
space O(N)
class Solution {
    public String rearrangeString(String s, int k) {
        if(k<=1) return s;
        char[] c = new char[s.length()];
        int[] cnt = new int[26];
        int init = k-1;
        int st = k-1;
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']+=100;
        }
        for(int i=0;i<26;i++){
            cnt[i] += i;
        }
        Arrays.sort(cnt);
        for(int i=0;i<=25;i++){
            int numbers = cnt[i]/100;
            char ch = (char)('a'+(cnt[i]%100));
            //if(numbers>(s.length()+k-1)/k) return "";
            while(numbers-->0){
                if(init>s.length()-1){
                    --st;
                    init = st;
                }
                c[init] = ch;
                init+=k;
            }
        }
        int[] check = new int[26];
        Arrays.fill(check,-k);
        for(int i=0;i<c.length;i++){
            if(i-check[c[i]-'a']<k) return "";
            check[c[i]-'a'] = i;
        }
        return String.valueOf(c);
    }
}