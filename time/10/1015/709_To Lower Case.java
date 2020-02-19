709. To Lower Case

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

class Solution {
    public String toLowerCase(String str) {
            StringBuilder sb = new StringBuilder();
            char c='0';
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>=65 && str.charAt(i)<=90)
                    c = (char)(str.charAt(i)+32);
                else 
                    c = str.charAt(i);
                sb.append(c);
            }
        return sb.toString();
    }
}