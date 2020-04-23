839. Similar String Groups
Hard

265

92

Add to List

Share
Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

 

Example 1:

Input: A = ["tars","rats","arts","star"]
Output: 2
 

Constraints:

1 <= A.length <= 2000
1 <= A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.

class Solution {
    int[] pre;
    int[] rank;
    public int numSimilarGroups(String[] A) {
        pre = new int[A.length];
        rank = new int[A.length];
        for(int i=0;i<A.length;i++){
            pre[i] = i;
        }
        int n = A.length;
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<A.length;j++){
                if(similar(A[i],A[j])){
                    int a = find(i);
                    int b = find(j);
                    if(a!=b){
                        union(a,b);
                        n--;                    
                    }
                }
            }
        }
        return n;
    }
    public boolean similar(String s1,String s2){
        int res = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)&&++res>2){
                return false;
            }
        }
        return true;
    }
    
    public void union(int x,int y){
        int root1 = find(x);
        int root2 = find(y);
        if(rank[root1]>rank[root2]){
            pre[root2] = root1;
        }
        else if(rank[root1]<rank[root2]){
            pre[root1] = root2;
        }
        else{
            pre[root2] = root1;
            rank[root1]++;
        }
    }
    public int find(int x){
        if(pre[x]==x) return x;
        return pre[x] = find(pre[x]);
    }
}