1269. Number of Ways to Stay in the Same Place After Some Steps
Hard

176

8

Add to List

Share
You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
Example 2:

Input: steps = 2, arrLen = 4
Output: 2
Explanation: There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
Example 3:

Input: steps = 4, arrLen = 2
Output: 8
 

Constraints:

1 <= steps <= 500
1 <= arrLen <= 10^6



class Solution {
    HashMap<String,Long> cache;
    long mod = (long) 1E9+7;
    public int numWays(int steps, int arrLen) {
        cache = new HashMap<>();
        return (int)(dfs(arrLen,0,steps));
    }
    public long dfs(int len,int idx,int d){
        if(idx<0||idx>=len||d<0) return 0;
        if(idx>d) return 0; // purning (never goes to 0 again) 
        if(d==0){
            if(idx==0) return 1;
            return 0;
        }
        String s = String.valueOf(d+"<=>"+idx);
        if(cache.containsKey(s)) return cache.get(s);  
        long ans = 0;
        ans+=dfs(len,idx-1,d-1);
        ans+=dfs(len,idx+1,d-1);
        ans+=dfs(len,idx,d-1);
        ans%=mod;
        cache.put(s,ans);
        return ans;
    }
}