345. Reverse Vowels of a String
Easy

682

1136

Add to List

Share
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".


class Solution {
    
    
    public String reverseVowels(String s) {
        char[] r = s.toCharArray();
        int left = 0;
        int right = r.length-1;
        
        while(left<right){
            if(!isVowels(r[left])){
                left++;
                continue;
            }
            if(!isVowels(r[right])){
                right--;
                continue;
            }
            swap(r,left++,right--);
        }
        return String.valueOf(r);
    }
    public void swap(char[] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
    public boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U') return true;
        return false;
    }
}