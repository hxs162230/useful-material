241. Different Ways to Add Parentheses

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10


class Solution {
    HashMap<String,List<Integer>> cache = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> lst = new ArrayList<>();
        if(cache.containsKey(input)) return cache.get(input);
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int j=0;j<left.size();j++){
                    for(int k=0;k<right.size();k++){
                        if(c=='+')
                            lst.add(left.get(j)+right.get(k));
                        else if(c=='-')
                            lst.add(left.get(j)-right.get(k));
                        else if(c=='*')
                            lst.add(left.get(j)*right.get(k));
                    }   
                }
            }
        }
        if(lst.isEmpty())  lst.add(Integer.parseInt(input));
        cache.putIfAbsent(input,lst);
        return lst;
    }
}