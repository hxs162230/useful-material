46. Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


T:O(N!)
S:O(N)
permutations 用一個 visit 數組做 backtracking


class Solution {
    List<List<Integer>> lol = new ArrayList<List<Integer>>();
    boolean[] visit;
    public List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        List<Integer> lst = new ArrayList<>();
        recur(nums,0,lst);
        return lol;
    }
    public void recur(int[] nums,int lv,List<Integer> lst){
        if(lv==nums.length){
            lol.add(new ArrayList<Integer>(lst));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(visit[i]) continue;
            visit[i]=true;
            lst.add(nums[i]);
            recur(nums,lv+1,lst);
            lst.remove(lst.size()-1);
            visit[i]=false;
        }
    }
}