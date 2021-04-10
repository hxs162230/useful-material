/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {

    public void findSecretWord(String[] wordlist, Master master) {
        
        int cnt = 10;
        while(cnt-->0){
               String guessWord = wordlist[new Random().nextInt(wordlist.length)];
               int matchNum = master.guess(guessWord);
               List<String> lsts = new ArrayList<>();
               for(String word:wordlist){
                int mat = matches(word,guessWord);
                if(matchNum==mat)
                    lsts.add(word);
               }
               wordlist = lsts.toArray(new String[lsts.size()]);
        }
    }

    public int matches(String a,String b){
        //if(a.length()!=b.length()) return 0;
        int num=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i))
                num++;
        }
        return num;
    }
}