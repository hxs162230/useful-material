14. Longest Common Prefix
Easy

1693

1523

Favorite

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<strs[0].length();j++){
            
            for(int i=1;i<strs.length;i++){
                if(j>strs[i].length()-1 || strs[i].charAt(j)!=strs[i-1].charAt(j))
                    return sb.toString();        
            }
            sb.append(strs[0].charAt(j));
        }
         return sb.toString();        
    }
}