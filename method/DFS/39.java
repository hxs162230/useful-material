39. Combination Sum
Medium

2667

81

Favorite

Share
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        recursiveSum(candidates, target,0, new ArrayList<Integer>(), res);
        
        return res;    
        
        
    }
    
    public void recursiveSum(int[] candidates, int target,int start, List<Integer> lst, List<List<Integer>> res){
        if(target<0) return;
        
        if(target==0){ 
            res.add(new ArrayList<Integer>(lst));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            
            lst.add(candidates[i]);
            recursiveSum(candidates,target-candidates[i],i,lst ,res);//可以選重複 所以用i當start
            lst.remove(lst.size()-1);
            
        }
        
        
        
        
    }
    
    
}