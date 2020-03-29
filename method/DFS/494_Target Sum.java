494. Target Sum

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 

Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums,S,0);
    }
    public int dfs(int[] nums,int S,int idx){
        int k=0;
        if(idx>=nums.length){
            if(S==0)
                return 1;
            else 
                return 0;
        }
        k+=dfs(nums,S-nums[idx],idx+1);
        k+=dfs(nums,S+nums[idx],idx+1);
        return k;
    }
}



Time complexity : O(l*n). The memomemo array of size l∗n has been filled just once. Here, ll refers to the range of sumsum and nn refers to the size of numsnums array.

Space complexity : O(n). The depth of recursion tree can go upto n.

class Solution {
    int[][] cache;
    int len = 2001;
    public int findTargetSumWays(int[] nums, int S) {
        cache = new int[nums.length][len];
        for(int[] c:cache) Arrays.fill(c,Integer.MIN_VALUE);
        return dfs(nums,S,0,0);
    }
    public int dfs(int[] nums,int S,int idx,int sum){
        int k=0;
        if(idx==nums.length){
            if(sum==S){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(cache[idx][sum+1000]!=Integer.MIN_VALUE) return cache[idx][sum+1000];
        
        k+=dfs(nums,S,idx+1,sum+nums[idx]);
        k+=dfs(nums,S,idx+1,sum-nums[idx]);
        return cache[idx][sum+1000] = k;
        
    }
}