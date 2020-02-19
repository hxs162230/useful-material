77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> lol=new ArrayList<List<Integer>>();
        ArrayList<Integer> arr =new ArrayList<>();
        
        if(k<=0||n<=0) return lol;
        
        
        recur(lol,arr,n,k,1);
        return lol;
    }
    public void recur(List<List<Integer>> lol, ArrayList<Integer> arr, int n, int k, int lv){
        if(k==arr.size()){
            lol.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i=lv;i<=n;i++){
            arr.add(i);
            recur(lol,arr,n,k,i+1);
            //深度方向和宽度方向都是以i~end扩展，而记录深度变化，通过step
            //（为了避免重复，后面的数都必须必前面的大）某分支下一个step的start = i+1
            arr.remove(arr.size()-1);
        }
        
    }
}