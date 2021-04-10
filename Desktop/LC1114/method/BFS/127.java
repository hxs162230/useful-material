T:O(N) N=word.length;
S:O(N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int lv=0;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                String word = q.poll();
                if(word.equals(endWord)) return lv+1; // include beginword 所以加上 1
                char[] transWord = word.toCharArray();
                for(int j=0;j<word.length();j++){
                    for(char c='a';c<='z';c++){
                        if(transWord[j]==c) continue;
                        char oldChar = transWord[j];
                        transWord[j]=c;
                        if(set.contains(String.valueOf(transWord))){
                            set.remove(String.valueOf(transWord));
                            q.add(String.valueOf(transWord));
                        }
                        transWord[j]=oldChar;
                    }
                }
            }
            lv++;
        }
        return 0;
    }
}