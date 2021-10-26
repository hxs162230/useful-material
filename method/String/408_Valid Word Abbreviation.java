408. Valid Word Abbreviation
Easy

146

636

Add to List

Share
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int m = word.length();
        int n = abbr.length();
        while(i<m&&j<n){
            int num = 0;
            StringBuilder sb = new StringBuilder();
            while(j<n&&isDigit(abbr.charAt(j))){
                sb.append(abbr.charAt(j));
                j++;
            }
            if(sb.length()!=0){
                if(sb.charAt(0)=='0') return false;
                num = Integer.parseInt(sb.toString());
            }
            i+=num;
            // System.out.println(num);
            // System.out.println(i+" "+j);
            if(i<m&&j<n&&word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
            }
            else return i==m&&j==n;
        }
        //System.out.print(i+" "+j);
        return i==m&&j==n;
    }
    public boolean isDigit(char c){
        return Character.isDigit(c);
    }
}
