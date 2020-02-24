273. Integer to English Words

Convert a non-negative integer to its english words representation. 

Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"


T:O(1)
S:O(1)

class Solution {
    final String[] digit= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    final String[] tens= {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    final String[] xten= {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        return trans(num);
    }
    public String trans(int num){
        String s = "";
        if(num>=1000000000)
        s+= trans(num/1000000000) +" Billion " +trans(num%1000000000);
        else if(num>=1000000)
        s+= trans(num/1000000) + " Million "+ trans(num%1000000);
        else if(num>=1000)
        s+= trans(num/1000) + " Thousand " + trans(num%1000);
        else if(num>=100)
        s+= trans(num/100) + " Hundred "+trans(num%100);
        else if(num>=20)
        s+= xten[num/10] +" "+ digit[num%10];
        else if(num>=10)
        s+= tens[num-10];
        else
        s+= digit[num%10];
        return s.trim();
    }
}