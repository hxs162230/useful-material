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