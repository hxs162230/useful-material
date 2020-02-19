class LFUCache {
	int cap;
	int min;
	HashMap<Integer,Integer> map = new HashMap<>();
	HashMap<Integer,Integer> vals = new HashMap<>();
	HashMap<Integer,Set<Integer>> freq = new HashMap<>();
    public LFUCache(int capacity) {
        this.cap = capacity;
        min=1;
        freq.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
    	if(!map.containsKey(key)) return -1;
    	int idx = vals.get(key);
    	vals.put(key,idx+1);
    	freq.get(idx).remove(key);
    	if(idx==min && freq.get(idx).size()==0){
    		min++;
    	}
    	if(!freq.containsKey(idx+1)){
    		freq.put(idx+1,new LinkedHashSet<>());
    	}
    	freq.get(idx+1).add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(cap<=0) return ;
        if(map.containsKey(key)){
        	get(key);
        	map.put(key,value);
        	return ; 
        }
        if(map.size()>=cap){
        	int rmKey = freq.get(min).iterator().next();
        	vals.remove(rmKey);
        	freq.get(min).remove(rmKey);
        	map.remove(rmKey);
        }
        map.put(key,value);
        vals.put(key,1);
        freq.get(1).add(key);
        min=1;
    }
}