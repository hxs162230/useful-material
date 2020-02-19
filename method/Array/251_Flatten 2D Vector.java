251. Flatten 2D Vector

Design and implement an iterator to flatten a 2d vector. 

It should support the following operations: next and hasNext.

 

Example:

Vector2D iterator = new Vector2D([[1,2],[3],[4]]);

iterator.next(); // return 1
iterator.next(); // return 2
iterator.next(); // return 3
iterator.hasNext(); // return true
iterator.hasNext(); // return true
iterator.next(); // return 4
iterator.hasNext(); // return false
 

Notes:

Please remember to RESET your class variables declared in Vector2D, 

as static/class variables are persisted across multiple test cases. 

Please see here for more details.

You may assume that next() call will always be valid, 

that is, there will be at least a next element in the 2d vector 

when next() is called.

class Vector2D {
        int[][] v;
        int i=0;
        int j=0; 
    public Vector2D(int[][] v) {
        this.v=v;
    }
    
    public int next() {
        if(hasNext()) return v[i][j++];
        throw new java.util.NoSuchElementException();
    }
    
    public boolean hasNext() {
        while(i<v.length){
            if(j<v[i].length) return true;
            j=0;
            i++;
        }
        return false;
    }
}



/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

class Vector2D {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;
    public Vector2D(int[][] v) {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        for(int[] sv:v){
            List<Integer> lst = new ArrayList<>();
            for(int ssv:sv){
                lst.add(ssv);
            }
            lol.add(lst);
        }
        i = lol.iterator();
        
    }
    
    public int next() {
        hasNext();
        return j.next();
    }
    
    public boolean hasNext() {
        while((j==null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j!=null&&j.hasNext();
    }
}