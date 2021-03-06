T:O(N*N) N=wordList.length; for bfs
  O(N^N) for dfs

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lol = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<>();
        HashMap<String,Set<String>> neighbors = new HashMap<>();
        HashMap<String,Integer> distance = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        distance.put(beginWord,0);
        bfs(beginWord,endWord,neighbors,distance,dict);
        dfs(beginWord,endWord,neighbors,distance,dict,solution,lol);
        return lol;
    }
    public void bfs(String beginWord,String endWord,HashMap<String,Set<String>> neighbors,HashMap<String,Integer> distance,HashSet<String> dict){
        for(String str:dict){
            neighbors.put(str,new HashSet<>());
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        boolean isFound = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                int curDistance = distance.get(word);
                List<String> nbs = getNeighbors(word,dict);
                for(String nb:nbs){
                    neighbors.get(word).add(nb);
                    if(!distance.containsKey(nb)){
                    distance.put(nb,curDistance+1);
                    if(endWord.equals(nb)){
                        isFound = true;
                    }
                    else{
                        q.add(nb);
                    }
                }
                }
            }
            if(isFound) break;
        }
    }
    public List<String> getNeighbors(String word,HashSet<String> dict){
        List<String> res = new ArrayList<>();
        char[] wordArr = word.toCharArray();
        for(int i=0;i<wordArr.length;i++){
            for(char j='a';j<='z';j++){
                if(wordArr[i]==j) continue;
                char old_char = wordArr[i];
                wordArr[i]=j;
                if(dict.contains(String.valueOf(wordArr)))
                res.add(String.valueOf(wordArr));
                wordArr[i]=old_char;
            }
        }
        return res;
    }

    public void dfs(String curWord,String endWord,HashMap<String,Set<String>> neighbors,HashMap<String,Integer> distance,HashSet<String> dict,List<String> solution,List<List<String>> lol){
            solution.add(curWord);
            if(endWord.equals(curWord)){
                lol.add(new ArrayList<String>(solution));
            }
            else{
                for(String next:neighbors.get(curWord)){
                    if(distance.get(next)==distance.get(curWord)+1){
                        dfs(next,endWord,neighbors,distance,dict,solution,lol);
                    }
                }
            }
            solution.remove(solution.size()-1);
    }
}