class AllOne {
	class Buckets{
		int val;
		Buckets prev;
		Buckets next;
		Set<String> keySet;
		public Buckets(int val){
			this.val = val;
			keySet = new HashSet<String>();
		}
	}
     Buckets head;
     Buckets tail;
	 HashMap<String,Integer> keyValue = new HashMap<>();
     HashMap<Integer,Buckets> Bucketslsts = new HashMap<>();
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Buckets(Integer.MIN_VALUE);
        tail = new Buckets(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;

    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keyValue.containsKey(key)){
        	change(key,1);
        }
        else{
        	keyValue.put(key,1);
        	if(head.next.val!=1){
        		addBucketafter(new Buckets(1),head);
        	}
        	head.next.keySet.add(key);
        	Bucketslsts.put(1,head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
    	if(keyValue.containsKey(key)){
        	int cnt = keyValue.get(key);
    		if(cnt==1){
    			keyValue.remove(key);
    			removeKeyfromBuckets(Bucketslsts.get(cnt),key);
    		}
    		else{
    			change(key,-1);
    		}
    	}
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return (tail.prev!=head?(String) tail.prev.keySet.iterator().next():"");
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return (head.next!=tail?(String) head.next.keySet.iterator().next():"");
    }
    public void change(String key,int offset){
    	int cnt = keyValue.get(key);
    	keyValue.put(key,cnt+offset);
    	
    	Buckets curBucket = Bucketslsts.get(cnt);
    	Buckets newBucket;
    	if(Bucketslsts.containsKey(cnt+offset)){
    		newBucket =Bucketslsts.get(cnt+offset);
    	}
    	else{
    		newBucket = new Buckets(cnt+offset);
    		Bucketslsts.put(cnt+offset, newBucket);
    		addBucketafter(newBucket,offset==1?curBucket:curBucket.prev);
    	}
    	newBucket.keySet.add(key);
    	removeKeyfromBuckets(curBucket,key);

    }

    public void removeKeyfromBuckets(Buckets rm,String key){
    	rm.keySet.remove(key);
    	if(rm.keySet.size()==0){
    		removeBucketfromList(rm);
    		Bucketslsts.remove(rm.val);
    	}
    }

    public void removeBucketfromList(Buckets rm){
     	rm.prev.next = rm.next;
    	rm.next.prev = rm.prev;
    	rm.next = null;
    	rm.prev = null;
    }

    public void addBucketafter(Buckets addAfter,Buckets thisOne){
    	addAfter.prev = thisOne;
    	addAfter.next = thisOne.next;
    	thisOne.next.prev = addAfter;
    	thisOne.next = addAfter;
    }
}
