146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

T:O(1)
S:O(N)

class LRUCache {
    HashMap<Integer,dblink> map = new HashMap<>();
    int cap;
    int size = 0;
    dblink head;
    dblink tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new dblink(-1,-1);
        tail = new dblink(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void removeFromLst(dblink node){
        dblink one = node.prev;
        dblink two = node.next;
        one.next = two;
        two.prev = one;
    }
    public void addTofront(dblink node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public dblink popLast(){
        dblink node = tail.prev;
        removeFromLst(node);
        return node;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        dblink ref = map.get(key);
        removeFromLst(ref);
        addTofront(ref);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cap<=0) return;
        if(map.containsKey(key)){
            map.get(key).value = value;
            this.get(key); 
        }
        else{
            dblink node = new dblink(key,value);
            map.put(key,node);
            addTofront(node);
            size++;
            if(size>cap){
                map.remove(this.popLast().key);
                size--;
            }
        }
    }
    class dblink{
        int key;
        int value;
        dblink prev;
        dblink next;
        public dblink(int k,int v){
            this.key = k;
            this.value = v;
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */