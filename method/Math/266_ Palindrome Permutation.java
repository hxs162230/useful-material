class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length()<=1) return true; 
        int cntOfOdd = 0;
        int[] cnt = new int[128];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            cnt[c]++;
        }
        for(int i=0;i<128;i++){
            if(cnt[i]%2==1){
                cntOfOdd++;
                if(cntOfOdd==2) return false;
            }
        }
        return cntOfOdd<=1;
    }
}