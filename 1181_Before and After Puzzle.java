
Given a list of phrases, generate a list of Before and After puzzles.

A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.

Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.

Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.

You should return a list of distinct strings sorted lexicographically.

 

Example 1:

Input: phrases = ["writing code","code rocks"]
Output: ["writing code rocks"]
Example 2:

Input: phrases = ["mission statement",
                  "a quick bite to eat",
                  "a chip off the old block",
                  "chocolate bar",
                  "mission impossible",
                  "a man on a mission",
                  "block party",
                  "eat my words",
                  "bar of soap"]
Output: ["a chip off the old block party",
         "a man on a mission impossible",
         "a man on a mission statement",
         "a quick bite to eat my words",
         "chocolate bar of soap"]
Example 3:

Input: phrases = ["a","b","a"]
Output: ["a"]
 

Constraints:

1 <= phrases.length <= 100
1 <= phrases[i].length <= 100


time:O(N*N*N) when using string pool copy / O(N*N) when using StringBuilder
space:O(N)

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        HashMap<String,List<Integer>> map = new HashMap<>();
        //indexing by first string of array element
        for(int i=0; i<phrases.length; i++){
            String[] element = phrases[i].split("\\s");
            String first = element[0];
            List<Integer> lst = map.getOrDefault(first,new ArrayList<Integer>());
            lst.add(i);
            map.put(first,lst);
        }
        //locate last element and find match(combine)
        TreeSet<String> set = new TreeSet<>();
        for(int i=0; i<phrases.length; i++){
            find(phrases,set,i,map);
        }
        //Collections.sort(set);
        return new ArrayList<>(set);
    }
    public void find(String[] phrases,TreeSet<String> set,int idx, HashMap<String,List<Integer>> map){
        String curStr = phrases[idx];
        String[] tiny = curStr.split("\\s");
        String last = tiny[tiny.length-1];
        if(map.get(last)==null) return;
        
        for(int i:map.get(last)){
            if(i==idx) continue;
            // StringBuilder sb = new StringBuilder(curStr);
            // String secondPart = new StringBuilder(phrases[i]).substring(last.length());
            // String combineStr = sb.append(secondPart).toString();
            String combineStr = curStr + phrases[i].substring(last.length());
            set.add(combineStr);
        }
    }
}