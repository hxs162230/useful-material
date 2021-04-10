class Solution {
    public boolean isPalindrome(String s) {
       int left=0;
       int right=s.length()-1;
        while(left<=right){
            char x = s.charAt(left);
            char y = s.charAt(right);
            if(!isAlphaNumeric(x)){
                left++;
                continue;
            }
            if(!isAlphaNumeric(y)){
                right--;
                continue;
            }
            char x_lower = toLowerCase(x);
            char y_lower = toLowerCase(y);
            if(x_lower!=y_lower) return false;
            left++;
            right--;
        }
        return true;
    }
    public boolean isAlphaNumeric(char c){
        if(c-'a'>=0&&c-'a'<26) return true;
        else if(c-'A'>=0&&c-'A'<26) return true;
        else if(c-'0'>=0&&c-'0'<=9) return true;
        else return false;
    }
    public char toLowerCase(char c){
        if(c-'a'>=0&&c-'a'<26) return c;
        else return (char) (c+32);
    }
}