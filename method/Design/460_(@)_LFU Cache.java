460. LFU Cache
Hard

1120

106

Add to List

Share
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.

 

Follow up:
Could you do both operations in O(1) time complexity?

 

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

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
        	return ; 2134
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