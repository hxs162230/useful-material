307. Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.


//store partial value in Binary index Tree
//O(logN) for update
//O(logN) for query
space O(N)

class NumArray {
        FenwickTree tree;
        int[] nums;
    public NumArray(int[] nums) {
        this.tree =  new FenwickTree(nums.length);
        this.nums = nums;

        for(int i=0;i<nums.length;i++){
        tree.updateFenwick(i+1,nums[i]);
        
        }
        for(int i=0;i<nums.length;i++)
        System.out.print(tree.fenwick[i+1]);
      
    }
    
    public void update(int i, int val) {
        tree.updateFenwick(i+1,val-nums[i]);
        this.nums[i]=val;
        
    }
    
    public int sumRange(int i, int j) {
       return tree.queryFenwick(j+1)-tree.queryFenwick(i);
    }
    
}
class FenwickTree{
    public int[] fenwick; 
    public FenwickTree(int n){
        fenwick = new int[n+1];
    }
    public void updateFenwick(int i,int delta){
        
        while(i<fenwick.length){
            fenwick[i]+=delta;
            i+=lowBit(i);
        }
        
    }
    public int queryFenwick(int i){
        int sum=0;
        while(i>0){
         sum+=fenwick[i];   
         i-=lowBit(i);   
        }
        return sum;
    }

    public int lowBit(int x){
        return x &(-x);
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */