953. Verifying an Alien Dictionary
Easy

324

120

Favorite

Share
In an alien language, surprisingly they also use english lowercase letters, 

but possibly in a different order. 

The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.

T:O(N) N = number of chars

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        if(len==1) return true;
        int[] rank = new int[26];
        for(int i=0;i<order.length();i++){
            rank[order.charAt(i)-'a']=i;    
        }
        for(int i=1;i<len;i++){
            if(compareWord(words[i-1],words[i],rank)>0){
                return false;
            }
        }
        return true;
    }
    public int compareWord(String word1,String word2,int[] rank){
        int m = word1.length();
        int n = word2.length();
        for(int i=0,j=0;i<m && j<n;i++,j++){
            int pos1 = rank[word1.charAt(i)-'a'];
            int pos2 = rank[word2.charAt(j)-'a'];
            if(pos1!=pos2){
                return pos1-pos2;
            }
        }
        return m-n;
    }
}