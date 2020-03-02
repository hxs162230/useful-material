1062. Longest Repeating Substring
Medium

122

6

Add to List

Share
Given a string S, 

find out the length of the longest repeating substring(s). 

Return 0 if no repeating substring exists.

 

Example 1:

Input: "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
Example 4:

Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.
 

Note:

The string S consists of only lowercase English letters from 'a' - 'z'.
1 <= S.length <= 1500

O (n^2 ) Approach 1
dp[i][j] means end with i, end with j , what's max length of common string.
abcbc. dp[2][4] = 2 because bc == bc, abc != cbc


class Solution {
    public int longestRepeatingSubstring(String S) {
        int len = S.length();
        int[][] dp = new int[len+1][len+1];
        int max = 0;
        for(int i=1;i<=len;i++){
            for(int j=i+1;j<=len;j++){
                if(S.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}

binary search + rolling hash
O(NlogN)
O(N)


class Solution {
    public int longestRepeatingSubstring(String S) {
        long mod = (long)Math.pow(2,32);
        int[] hash = new int[S.length()];
        int a =26;
        for(int i=0; i<S.length(); i++){
            hash[i] = S.charAt(i)-'a';
        }
        int left = 0;
        int right = S.length();
        while(left<right){

        	//find shortest invalid length;
            int mid = left+(right-left)/2;
            if(search(mid,a,mod,hash)!=-1){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        //right-1 is the longest vali length;
        return right-1;
    }
    //rolling hash for searching (return idx if duplicates occurred)
    //otherwise return -1
    public int search(int len, int a,long mod, int[] hash){
        HashSet<Long> set = new HashSet<>();
        long aa = 1;
        long hash_num = 0;
        for(int i=0;i<len;i++){
            hash_num = (hash_num*a+hash[i])%mod;
        }
        set.add(hash_num);
        for(int i=1;i<=len;i++){
            aa = aa*a%mod;
        }
        for(int i=1;i<hash.length-len+1;i++){
            hash_num = (hash_num*a-aa*hash[i-1]%mod+mod)%mod;
            hash_num = (hash_num + hash[i+len-1])%mod;
            if(set.contains(hash_num)){
                return i;
            }
            else{
                set.add(hash_num);
            }
        }
        return -1;
    }
}