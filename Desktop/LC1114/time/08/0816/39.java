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