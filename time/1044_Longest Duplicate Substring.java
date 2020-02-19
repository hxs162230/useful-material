Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  

(The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  

(If S does not have a duplicated substring, the answer is "".)

 

Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""
 

Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.

Time complexity : O(NlogN).
O(logN) for the binary search and O(N) for Rabin-Karp algorithm.
Space complexity :O(N) to keep the hashset.

T:O(NlogN)
S:O(N)

class Solution {
    public String longestDupSubstring(String S) {
        int[] hashing = new int[S.length()];
        int a = 26;
        long mod = (long)Math.pow(2,32);// different from 1<<32 (1<<32==1<<0)
        for(int i=0;i<S.length();i++){
            hashing[i] = S.charAt(i)-'a';
        }
        int left=0;
        int right=S.length();
        while(left<right){ //find smallest length cannot have duplicate
            int L = left+(right-left)/2;
            if(search(L,hashing,a,mod)!=-1){
                left=L+1;
            }
            else{
                right=L;
            }
        }
        //right-1 == largest length to have duplicate substring;
        int start = search(right-1,hashing,a,mod);
        
        return S.substring(start,start+right-1);
    }
    public int search(int len,int[] hash,int a,long mod){
        HashMap<Long,Integer> cnt = new HashMap<>();  
        long hash_num = 0;
        for(int i=0;i<len;i++){
            hash_num = (hash_num*a+hash[i])%mod;
        }
        cnt.put(hash_num,1);
        long val = 1;
        for(int i=1;i<=len;i++) val=(val*a)%mod;
        for(int i=1;i<hash.length-len+1;i++){
            hash_num = (hash_num*a-val*hash[i-1]%mod+mod)%mod;
            hash_num = (hash_num+hash[i+len-1])%mod;
            
            if(!cnt.containsKey(hash_num)){
                cnt.put(hash_num,1);
            }
            else{
                return i;
            }
        }
        return -1;
    }
}