727. Minimum Window Subsequence
Hard

533

26

Add to List

Share
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 


 class Solution {
    public String minWindow(String S, String T) {
        int sidx = 0;
        int tidx = 0;
        int min = S.length()+1;
        int st = -1;

        while(sidx<S.length()){
            if(S.charAt(sidx)==T.charAt(tidx)){
                tidx++;
                if(tidx==T.length()){
                    int end = sidx;
                    while(--tidx>=0){
                        while(S.charAt(sidx--)!=T.charAt(tidx));
                    }
                    sidx++;
                    tidx++;
                    if(end-sidx+1<min){
                        min = end-sidx+1;
                        st = sidx;
                    }
                }
            }
            sidx++;
        }
        return st==-1?"":S.substring(st,st+min);
    }
}