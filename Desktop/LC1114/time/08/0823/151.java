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