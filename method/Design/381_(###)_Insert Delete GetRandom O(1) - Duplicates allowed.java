381. Insert Delete GetRandom O(1) - Duplicates allowed
Hard

637

56

Add to List

Share
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

class RandomizedCollection {
    List<Integer> lst;
    HashMap<Integer,Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.lst = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            map.get(val).add(lst.size());
            lst.add(val);
            return false; 
        }
        else{
            map.put(val,new HashSet<>());
            map.get(val).add(lst.size());
            lst.add(val);
            return true;
        }
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        if(!map.get(val).contains(lst.size()-1)){
            int lastV = lst.get(lst.size()-1);
            int pre_idx = map.get(val).iterator().next();
            map.get(lastV).add(pre_idx);
            map.get(lastV).remove(lst.size()-1);
            map.get(val).add(lst.size()-1);
            map.get(val).remove(pre_idx);
            lst.set(pre_idx,lastV);
        }
        map.get(val).remove(lst.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        lst.remove(lst.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(new Random().nextInt(lst.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

given val


