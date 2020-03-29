78. Subsets
Medium

2488

60

Favorite

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

class Solution {
    private List<List<Integer>> lol;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length<=0) return null;
        lol=new ArrayList<List<Integer>>();
        recur(nums,0,new ArrayList<Integer>());
        return lol;
    }
    public void recur(int[] nums,int idx,List<Integer> lst){
        
        if(idx<=nums.length){
            lol.add(new ArrayList<Integer>(lst));
            
        }
         
        
        for(int i=idx;i<nums.length;i++){
        lst.add(nums[i]);
        recur(nums,i+1,lst);
        lst.remove(lst.size()-1);
        }
    }
}