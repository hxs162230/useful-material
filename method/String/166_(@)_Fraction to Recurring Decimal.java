166. Fraction to Recurring Decimal
Medium

586

1281

Favorite

Share
Given two integers representing the numerator and denominator of a fraction, 

return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"


XOR operations

+  +  => 0

-  -  => 0

+  -  => 1

-  +  => 1


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator>0)^(denominator>0)) sb.append("-");
        long num = Math.abs((long)numerator);
        long div = Math.abs((long)denominator);
        long a = (long)num/div;
        long b = (long)num%div;
        sb.append(String.valueOf(a));
        if(numerator%denominator==0) return sb.toString();
        sb.append(".");

        
        HashMap<Long,Integer> map = new HashMap<>();
        while(b!=0){
            if(map.containsKey(b)){
                sb.insert(map.get(b),"(");
                sb.append(")");
                break;
            }
            map.put(b,sb.length());
            b*=10;
            sb.append(String.valueOf(b/div));
            b%=div;
        }
        return sb.toString();
    }
}