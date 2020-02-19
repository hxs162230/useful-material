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
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> lst = new ArrayList<>();
        recur(map,lst,0,digits.length(),digits);
        return lst;
    }
    public void recur(String[] map,List<String> lst,int lv,int len,String digits){
        if(lv==len){
            lst.add(set);
            return;
        }
        String set += map[digits.charAt(lv)-'0'];
        for(int i=0;i<set.length();i++){
            recur(map,lst,lv+1,len);
        }
    }
}