216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, 

given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lsts = new ArrayList<List<Integer>>();
        recur(1,k,n,lsts,new ArrayList<>());
        return lsts;
    }
    public void recur(int level,int k,int n,List<List<Integer>> lsts,List<Integer> lst){
        if(n<0) return;
        if(n==0&&lst.size()==k){
            lsts.add(new ArrayList(lst));
            return;
        }
        for(int i=level;i<=9;i++){
            lst.add(i);
            recur(i+1,k,n-i,lsts,lst);
            lst.remove(lst.size()-1);
        }
    }
}