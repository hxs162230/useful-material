1239. Maximum Length of a Concatenated String with Unique Characters
Medium

173

34

Add to List

Share
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.

// Without memory, the runtime would be O(N!)
// With memory, the runtime should be reduced to O(N^2) (memoizations)

// Best way to visualize this is a draw a search tree.


class Solution {
    private int res = 0;
    public int maxLength(List<String> arr) {
        if(arr.size()==0) return res;
        dfs(arr,"",0);
        return res;
    }
    public void dfs(List<String> lst,String comb,int idx){
        boolean isValid = isUnique(comb);
        
        if(isValid){
            res = Math.max(res,comb.length());
        }
        
        if(idx==lst.size()||!isValid){
            return ;
        }
        
        
        
        for(int i=idx;i<lst.size();i++){
            dfs(lst,comb+lst.get(i),i+1);
        }
    }
    public boolean isUnique(String s){
        int[] cnt = new int[26];
        for(int i=0;i<s.length();i++){
            if(cnt[s.charAt(i)-'a']++>0) return false;
            
        }
        return true;
    }
}