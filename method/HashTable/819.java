819. Most Common Word
Easy

394

986

Favorite

Share
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.

T:O(N)


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] word = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        String str = "";
        for(String w:word){
            if(!map.containsKey(w))
                map.put(w,1);
            else
                map.put(w,map.get(w)+1);
        }
        for(String b:banned){
            //System.out.println(b);
            if(map.containsKey(b))
                map.remove(b);
        }
        
        for(String m:map.keySet()){
             //System.out.print(m);
            int value = map.get(m);
            if(value>max) {
                str=m;
                max=value;
            }
        }
        return str;
    }
}