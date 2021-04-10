40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.



For those who don't understand how to avoid duplicate by:
if "(i > cur && cand[i] == cand[i-1]) continue;

when we should skip a number? not just it's the same as previous number, but also when it's previous number haven't been added!

i > cur means cand[i - 1] is not added to the path (you should know why if you understand the algorithm), so if cand[i] == cand[i-1], then we shouldn't add cand[i].

This tricky is very smart.

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<>();
        combineDfs(candidates,0,target,lst);
        return res;
    }
    public void combineDfs(int[] nums,int st,int target,List<Integer> lst){
        if(target==0){
            res.add(new ArrayList<>(lst));
            return;
        }
        if(target<0) return;
        for(int i=st;i<nums.length;i++){
            if(i>st &&nums[i]==nums[i-1]) continue;
            lst.add(nums[i]);
            combineDfs(nums,i+1,target-nums[i],lst);
            lst.remove(lst.size()-1);
        }
    }
}