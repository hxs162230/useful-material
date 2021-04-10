706. Design HashMap
Easy

470

71

Favorite

Share
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

class MyHashMap {
    private  List<Integer[]> lol;
    private final int pageSize = 1000;
    private final int pageNum = 1000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        lol = new ArrayList<Integer[]>();
        for(int i=0;i<pageNum;i++){
            lol.add(null);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int y = key/pageSize;
        int x = key%pageNum;
        if(lol.get(x)==null){
            lol.set(x,new Integer[this.pageSize]);
        }
        lol.get(x)[y] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int y = key/pageSize;
        int x = key%pageNum;
        if(lol.get(x)==null){
            return -1;
        }
        if(lol.get(x)[y]==null){
            return -1;
        }
        return lol.get(x)[y];
        //return 0;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int y = key/pageSize;
        int x = key%pageNum;
        if(lol.get(x)==null){
            return ;
        }
        lol.get(x)[y] = null;
    }
}