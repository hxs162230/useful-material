72. Edit Distance
Hard

2620

41

Favorite

Share
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

class Solution {
    int[][] cache;
    public int minDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();
        cache=new int[word1.length()][word2.length()];
        return dfs(word1,word2,0,0);
    }
    public int dfs(String word1,String word2,int i,int j){
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        if(cache[i][j]>0) return cache[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            cache[i][j] = dfs(word1,word2,i+1,j+1);
        }
        else{
        int delete = dfs(word1,word2,i+1,j);
        int insert = dfs(word1,word2,i,j+1);
        int replace = dfs(word1,word2,i+1,j+1);
        cache[i][j] = Math.min(delete,Math.min(insert,replace))+1;
        }
        return cache[i][j];
    }
}