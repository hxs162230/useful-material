class Solution {
    public int compress(char[] chars) {
    	int j=0;
    	int idx=0;
        for(int i=0;i<chars.length;i=j){
        	while(j<chars.length&&chars[i]==chars[j]) j++;
        	chars[idx++]=chars[i];
        	if(j-i==1) continue;
        	String val = String.valueOf(j-i);
        	for(int k=0;k<val.length();k++){
        		chars[idx++]=val.charAt(k);
        	}
        }
        return idx;
    }
}