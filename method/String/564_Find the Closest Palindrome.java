564. Find the Closest Palindrome
Hard

255

816

Add to List

Share
Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.



O(len) for time 
O(len) for space

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        
        String sub = n.substring(0,len%2==0?len/2-1+1:len/2+1);
        List<Long> lst = new ArrayList<>();
        
        lst.add(getParlin(sub,len%2==0));
        lst.add(getParlin(String.valueOf(Long.parseLong(sub)+1),len%2==0));
        lst.add(getParlin(String.valueOf(Long.parseLong(sub)-1),len%2==0));
        lst.add((long)Math.pow(10,len)+1);
        lst.add((long)Math.pow(10,len-1)-1);
        
        long diff = Long.MAX_VALUE;
        long cand = 0;
        long tar = Long.parseLong(n);
        for(long e : lst){
            //System.out.print(e+" ");
            if(e==tar) continue;
            if(Math.abs(e-tar)<diff){
                cand = e;
                diff = (long)Math.abs(e-tar);
            }
            else if(Math.abs(e-tar)==diff){
                cand = Math.min(e,cand);
            }
        }
               
        
        
        return String.valueOf(cand);
    }
    public long getParlin(String s,boolean even){
        StringBuilder sb = new StringBuilder(s);
        if(!even) sb.setLength(sb.length()-1);
        sb.reverse();
        return Long.parseLong(s+sb.toString());
    }
    
}