336. Palindrome Pairs

Given a list of unique words, find all pairs of distinct indices (i, j) 

in the given list, so that the concatenation of the two words, 

i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]


T:O(len*numOfchar)
S:O(MN)

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            if(map.containsKey("")){
                if(map.get("")==i) continue;
                if(isValid(words[i])){
                    lol.add(Arrays.asList(i,map.get("")));
                    lol.add(Arrays.asList(map.get(""),i));
                }
            }
        }
        for(int i=0;i<words.length;i++){
            String rstr = reverse(words[i]);
            if(map.containsKey(rstr)){
                if(map.get(rstr)==i) continue;
                lol.add(Arrays.asList(i,map.get(rstr)));//只需加一次  因為掃描全部
            }
        }
        for(int i=0;i<words.length;i++){
            for(int cut=1;cut<words[i].length();cut++){
                if(isValid(words[i].substring(cut))){
                     String rstr1 = reverse(words[i].substring(0,cut));
                if(map.containsKey(rstr1)){
                    if(map.get(rstr1)==i) continue;
                    lol.add(Arrays.asList(i,map.get(rstr1)));
                }
                }

                if(isValid(words[i].substring(0,cut))){
                     String rstr2 = reverse(words[i].substring(cut));
                if(map.containsKey(rstr2)){
                    if(map.get(rstr2)==i) continue;
                    lol.add(Arrays.asList(map.get(rstr2),i));
                }
                }
            }
        }
        return lol;
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public boolean isValid(String s){
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}