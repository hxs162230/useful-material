You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
 

Constraints:

1 <= d, f <= 30
1 <= target <= 1000

top down memoization 
They way to look at complexity for 
top down approaches is look at (how can you fill a state) * (how many states are possible). 
                                    f branches            *     d*target possible states
Runtime: O(d * f * target).   
Memory: O(d * target) for the memoization.
//string cache implementation
class Solution {
    int mod = (int)Math.pow(10,9)+7;
    HashMap<String,Integer> cache = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target) {
        if(target==0&&d==0){
            return 1;
        }
        if(target<=0||d<=0) return 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        String str = sb.append(d).append("@").append(target).toString();
        if(cache.containsKey(str)) return cache.get(str);
        for(int i=1;i<=f;i++){
            ans+=numRollsToTarget(d-1,f,target-i);
            ans%=mod;
        }
        cache.put(str,ans);
        return ans;
    }
}
//array cache implementation
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int)Math.pow(10,9)+7;
        // why we use object arr here?
        // because we can store value 0 of  index d&target
        // if  we use int[][] here we cant not cache the value 0
        Integer[][] cache = new Integer[d+1][target+1]; 
        return dfs(d,f,target,cache,mod)%mod;
    }
    public Integer dfs(int d, int f, int target,Integer[][] cache,int mod){
        if(target==0&&d==0){
            return 1;
        }
        if(target<=0||d<=0) return 0;
       
        if(cache[d][target]!=null) return cache[d][target];
        int ans = 0;
        for(int i=1;i<=f;i++){
            ans+=dfs(d-1,f,target-i,cache,mod);
            ans%=mod;
        }
        return cache[d][target]=ans;
    }
}