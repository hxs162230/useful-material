254. Factor Combinations

Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:

Input: 1
Output: []
Example 2:

Input: 37
Output:[]
Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

O(N^(logN))

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<>();
        dfsCombinations(2,n,res,lst);
        return res;
    }
     public void dfsCombinations(int st,int n,List<List<Integer>> res,List<Integer> lst){
         if(n==1){
             if(lst.size()>1) res.add(new ArrayList<>(lst));
             return;
         }
         for(int i=st;i<=n;i++){
             if(n%i==0){
                 lst.add(i);
                 dfsCombinations(i,n/i,res,lst);
                 lst.remove(lst.size()-1);
             }
         }
     }
}