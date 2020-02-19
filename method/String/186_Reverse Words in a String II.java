186. Reverse Words in a String II

Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

T:O(N)
S:O(1)

class Solution {
    public void reverseWords(char[] s) {
        for(int i=0;i<s.length;i++){
            int j=i;
            while(j<s.length&&s[j]!=' '){
                j++;
            }
            reverse(s,i,j-1);
            i=j;
        }
        reverse(s,0,s.length-1);
        
        
    }
    public void reverse(char[] s,int a,int b){
        while(a<b){
            swap(s,a++,b--);
        }
    }
    public void swap(char[] s,int a,int b){
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }
}