47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        int[] visit=new int[nums.length];
        Arrays.sort(nums);
        recur(lol,new ArrayList<Integer>(),nums,0,visit);
        
        return lol;
    }
    public void recur(List<List<Integer>> lol,ArrayList<Integer> arr,int[] nums,int lv,int[] visit){
        if(lv==nums.length) {
            lol.add(new ArrayList<Integer>(arr));   
            return;
        }
        // [1,1,2]这样的实例就会出现重复的结果，那么我们应该如何避免重复呢？方法就是对与重复的元素循环时跳过递归的调用只对第一个未被使用的进行递归
        for(int i=0;i<nums.length;i++){
            if(visit[i]==1) continue;
            if(i>0 && nums[i]==nums[i-1] && visit[i-1]==1) continue;
            visit[i]=1;
            arr.add(nums[i]);
            recur(lol,arr,nums,lv+1,visit);
            arr.remove(arr.size()-1);
            visit[i]=0;
        }
    }
}