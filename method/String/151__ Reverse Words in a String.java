151. Reverse Words in a String

Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

class Solution {
    public String reverseWords(String s) {
        String tmp="";
        String result="";
        int c=0;
        s=s.trim();
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)==' '){
                if(c==0){
                result=" "+tmp+result;
                c++;
                }
                tmp="";
            }
            else{
                tmp+=s.charAt(i);
                c=0;
            }

            
        }
        return tmp+result;
    }
}



class Solution {
    public String reverseWords(String s) {
        if(s.length()==0||s==null) return s;
        s=s.trim();
        StringBuilder sb = new StringBuilder();
        for(String ss:s.split("\\s+")){
            sb.append(reverseOne(ss));
            sb.append(" ");
        }
        
        return sb.reverse().substring(1);
    }
    
    public String reverseOne(String s){
        int left = 0;
        int right = s.length()-1;
        char[] a = s.toCharArray();
        while(left<right){
            swap(left++,right--,a);
        }
        return String.valueOf(a);
    }
    
    public void swap(int i,int j,char[] a){
        char o = a[i];
        a[i] = a[j];
        a[j] = o;
    }
}