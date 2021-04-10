541. Reverse String II

Given a string and an integer k, 

you need to reverse the first k characters for every 2k characters 

counting from the start of the string. 

If there are less than k characters left, reverse all of them. 

If there are less than 2k but greater than or equal to k characters, 

then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]


T:O(N/2k)
S:O(N)

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if(k>n) return reverse(s,0,n-1);
        for(int i=0;i<n;i+=2*k){
            if(i+2*k-1<n)
                s=reverse(s,i,i+(k-1));
            else if(i+k-1<=n)
                s=reverse(s,i,i+(k-1));
            else 
                s=reverse(s,i,n-1);
        }
        return s;
    }
    public String reverse(String s,int i,int j){
        char[] c = s.toCharArray();
        while(i<j){
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;j--;
        }
        return String.valueOf(c);
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            if(i+k>=s.length()) reverse(c,i,s.length()-1);
            else if(i+2*k>=s.length()) reverse(c,i,i+k-1);
            else reverse(c,i,i+k-1);
        }
        return String.valueOf(c);
    }
    public void reverse(char[] c,int i,int j){
        while(i<j){
            swap(c,i++,j--);
        }
    }
    public void swap(char[] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}