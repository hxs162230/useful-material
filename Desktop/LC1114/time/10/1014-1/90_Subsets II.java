90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


class Solution {
    List<List<Integer>> lol;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length<=0) return null;
        lol=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        recur(nums,0,new ArrayList<Integer>());
        return lol;
    }
    public void recur(int[] nums,int idx,List<Integer> lst){
        if(idx<=nums.length){
            lol.add(new ArrayList<>(lst));
        }
        
        for(int i=idx;i<nums.length;i++){
        if(i>idx && nums[i]==nums[i-1]) continue; 同層但之前遞歸到了 只對第一個作遞歸
        lst.add(nums[i]);
        recur(nums,i+1,lst);
        lst.remove(lst.size()-1);
        }
    }
}