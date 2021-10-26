726. Number of Atoms
Hard

379

121

Add to List

Share
Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.
Example 2:
Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:
Input: 
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.

O(len) for time
O(len) for space


class Solution {
    public String countOfAtoms(String formula) {
        Map<String,Integer> atom = computeAtom(formula);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> e:atom.entrySet()){
            //System.out.println(e.getKey());
            sb.append(e.getKey());
            if(e.getValue()>1){
                sb.append(e.getValue());
            }
        }
        return sb.toString();
    }
    public Map<String,Integer> computeAtom(String s){
        int len = s.length();
        Map<String,Integer> map = new TreeMap<>();
        if(len==0) return map;
        int i = 0;
        while(i<len){
            if(s.charAt(i)=='('){
                int j=i;
                int cnt = 0;
                for(;j<len;j++){
                    if(s.charAt(j)=='(') cnt++;
                    else if(s.charAt(j)==')') cnt--;
                    if(cnt==0) break;
                }
                String subs = s.substring(i+1,j);
                Map<String,Integer> submap = computeAtom(subs);
                j++;
                int k = j;
                int n = 1;
                while(k<len&&Character.isDigit(s.charAt(k))) k++;
                if(k>j){
                    n = Integer.parseInt(s.substring(j,k));
                }
                
                for(String key:submap.keySet()){
                    map.put(key,map.getOrDefault(key,0)+n*submap.get(key));
                }
                i = k;
            }   
            else{
                int j = i+1;
                while(j<len&&s.charAt(j)-'a'>=0&&s.charAt(j)-'a'<=25) j++;
                String atom = s.substring(i,j);
                int n = 1;
                int k = j;
                while(k<len&&Character.isDigit(s.charAt(k))){
                    k++;
                }
                if(k>j){
                    n = Integer.parseInt(s.substring(j,k));
                }
                map.put(atom,map.getOrDefault(atom,0)+n);
                i = k;
            }
        }
        return map;
    }
}