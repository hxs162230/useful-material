class Solution {
   // private HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        HashMap<String,List<String>> memo=new HashMap<>();
        return wordSep(set,s,memo);
    }
    public List<String> wordSep(HashSet<String> set,String s,HashMap<String,List<String>> memo){
        List<String> ans=new ArrayList<>();
        if(memo.containsKey(s)){
           return memo.get(s);
        }
        if(set.contains(s)){
            ans.add(s); //不return
        }
        for(int i=1;i<s.length();i++){
            String right=s.substring(i);
            if(set.contains(right)){
                List<String> left = wordSep(set,s.substring(0,i),memo);
                for(int j=0;j<left.size();j++){
                    ans.add(left.get(j)+" "+right);
                }
            }
        }
        memo.put(s,ans);
        return ans;
    }
}