491. Increasing Subsequences
Medium

608

106

Add to List

Share
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.

 

Example:

Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 

Note:

The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.



class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void dfs(int[] nums,int st,
                    List<Integer> sol,List<List<Integer>> res){
        if(sol.size()>=2){
            res.add(new ArrayList<>(sol));
        }
        Set<Integer> set = new HashSet<>();//相鄰數不可重複遞歸  類似permutations  (不完全是,permutations st會回到 0)
        								   //因為是in sequence問題 介於 combination和permutation之間 ?
        								   // 此題沒有sort!!!!
        
        for(int i=st;i<nums.length;i++){
            if(set.contains(nums[i])) continue; //相同的相鄰數   skip!!!
            if(sol.size()==0||sol.get(sol.size()-1)<=nums[i]){
                set.add(nums[i]);
                sol.add(nums[i]);
                dfs(nums,i+1,sol,res);
                sol.remove(sol.size()-1);
            }
        }
    }
}