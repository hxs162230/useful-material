809. Expressive Words
Medium

229

657

Add to List

Share
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
 

Accepted
34.6K
Submissions
74.1K


class Solution {
    // we find that len2 is smaller than 3, it means the letter cannot be extended, so len1 must equals to len2, otherwise this word is not stretchy. 
    // In the other case, if len2 equals to or larger than 3, we must have len2 equals to or larger than len1, otherwise there are not enough letters in S to match the letters in word.
    //
    //S      是長的 
    //word   是正常長度的
    public int expressiveWords(String S, String[] words) {
        if(S==null||words.length==0) return 0;
        int cnt = 0;
        for(String word:words){
            if(isStretchy(word,S)) cnt++;
        }
        return cnt;
    }
    public boolean isStretchy(String word,String S){
        if(word==null) return false;
        int i = 0;
        int j = 0;
        while(i<word.length()&&j<S.length()){
            if(word.charAt(i)==S.charAt(j)){ 
                int len1 = getIndex(i,word);
                int len2 = getIndex(j,S);
                if(len1!=len2&&len2<3||len2>=3&&len1>len2) return false;
                i+=len1;
                j+=len2;
            }
            else{
                return false;
            }
        }
        return i==word.length()&&j==S.length();
    }
    public int getIndex(int idx,String s){
        int j = idx;
        while(j<s.length()&&s.charAt(idx)==s.charAt(j)){
            j++;
        }
        return j-idx;
    }
}