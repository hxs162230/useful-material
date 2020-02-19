class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> lst = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
        public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b){
            return (a.getValue()!=b.getValue()?b.getValue()-a.getValue():a.getKey().compareTo(b.getKey()));
        }     
        });
        for(String word:words){
            if(!map.containsKey(word))
                map.put(word,1);
            else
                map.put(word,map.get(word)+1);
        }
        for(Map.Entry<String,Integer> m:map.entrySet()){
            pq.add(m);
        
        }
        for(int i=k;i>0;i--){
            if(pq.peek()==null) break;
            lst.add(pq.poll().getKey());
        }
        return lst;
    }
}