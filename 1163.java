
1163. Last Substring in Lexicographical Order
Hard

93

189

Add to List

Share
Given a string s, return the last substring of s in lexicographical order.

 

Example 1:

Input: "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
Example 2:

Input: "leetcode"
Output: "tcode"
 

Note:

1 <= s.length <= 4 * 10^5
s contains only lowercase English letters.


class Solution {
    public String lastSubstring(String s) {
        int k = 0;
        int len = s.length();
        int i=0;
        int j=1;
        while(i+k<len&&j+k<len){
            int cmp = s.charAt(i+k)-s.charAt(j+k);
            if(cmp==0){
                k++;
                continue;
            }
            if(cmp<0){
                i=i+k+1;
            }
            else{
                j=j+k+1;
            }
            if(i==j) j++;
            k=0;
        }
        return s.substring(Math.min(i,j));
    }
}