556. Next Greater Element III

Given a positive 32-bit integer n, 

you need to find the smallest 32-bit integer 

which has exactly the same digits existing in the integer n and is greater in value than n. 

If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1

similar to next permutation LC#31

class Solution {
    public int nextGreaterElement(int n) {
        if(n==0) return -1;
        String s = String.valueOf(n);
        int len = s.length();
        int i=len-1;
        while(i>0&&s.charAt(i-1)-'0'>=s.charAt(i)-'0') i--;
        if(i>0){
            int cmp = s.charAt(i-1)-'0';
            int j=len-1;
            while(s.charAt(j)-'0'<=cmp) j--;
            s = swap(i-1,j,s);
        }
        s = reverse(i,len-1,s); 
        if(Long.parseLong(s)>Integer.MAX_VALUE) return -1;
        if(Integer.parseInt(s)<=n) return -1;
        return Integer.parseInt(s);
    }
    public String swap(int i,int j,String s){
        char[] crr = s.toCharArray();
        char o = crr[i];
        crr[i] = crr[j];
        crr[j] = o;
        return String.valueOf(crr);
    }
    public String reverse(int i,int j,String s){
        char[] crr = s.toCharArray();
        while(i<j){
            char o = crr[i];
            crr[i] = crr[j];
            crr[j] = o;
            i++;j--;
        }
        return String.valueOf(crr);
    }
}