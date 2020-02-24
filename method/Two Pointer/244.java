244. Shortest Word Distance II
Medium

255

95

Favorite

Share
Design a class which receives a list of words in the constructor, 

and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. 

Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

class WordDistance {
    HashMap<String,List<Integer>> dis;
    public WordDistance(String[] words) {
        dis = new HashMap<>();
        for(int i=0;i<words.length;i++){
            dis.putIfAbsent(words[i],new ArrayList<>());
            dis.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> lstA = dis.get(word1);
        List<Integer> lstB = dis.get(word2);
        int res=Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<lstA.size()&&j<lstB.size()){
            res = Math.min(res,Math.abs(lstA.get(i)-lstB.get(j)));
            if(lstA.get(i)<lstB.get(j)) ++i;
            else ++j;
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */