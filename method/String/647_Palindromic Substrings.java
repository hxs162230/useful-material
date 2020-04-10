647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings 

in this string.

The substrings with different start indexes or end indexes are counted as different 

substrings even they consist of same characters.

class Solution {
    int res=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        return res;
    }
    public void isPalindrome(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
          
                i--;
                j++;
                res++;
            
        }
    }
}



class Solution {
    public int countSubstrings(String s) {
        String mana = process(s);
        int[] P = new int[mana.length()];
        int C = 0;
        int R = 0;
        for(int i=1;i<P.length-1;i++){
            int imirror = 2*C-i;
            if(R>i){
                P[i] = Math.min(R-i,P[imirror]);
            }
            else{
                P[i] = 0;
            }
            while(mana.charAt(i+1+P[i])==mana.charAt(i-1-P[i])){
                P[i]++;
            }
            if(i+P[i]>R){
                R = i+P[i];
                C = i;
            }
        }
        int cnt = 0;
        // 3 ->2
        // 2 ->1
        // 1 ->1
        
        for(int i=1;i<P.length-1;i++){
            cnt+=(P[i]+1)/2;
        }        
        return cnt;
    }
    public String process(String s){
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        sb.append("#");
        for(char c :s.toCharArray()){
            sb.append(c);
            sb.append("#");
        }
        sb.append("$");
        return sb.toString();
    }
}