17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


T:O(len^digits)  len近似於3
S:O(digits)
backtracking
s pass by value 所以不用寫 backtrack語法
 


class Solution {
     List<String> lst = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()<=0) return lst;
        String[] map = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        
        recur(map,digits,0,"");
        return lst;
    }
    public void recur(String[] map,String digits,int lv,String s){
        if(lv==digits.length()){
            lst.add(s);
            return;
        }
        int len = map[digits.charAt(lv)-'0'].length();
        for(int i=0;i<len;i++){
            recur(map,digits,lv+1,s+map[digits.charAt(lv)-'0'].charAt(i));
        }
    }
}