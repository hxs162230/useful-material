443. String Compression
Easy

571

1776

Add to List

Share
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

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