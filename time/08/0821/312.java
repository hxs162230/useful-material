312. Burst Balloons
Hard

1664

49

Favorite

Share
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

T:O(N^3)

class Solution {
    public int maxCoins(int[] nums) {
 		int[] lst = new int[nums.length+2];
 		for(int i=1;i<=nums.length;i++){
 			lst[i]=nums[i-1];
 		}       
 		lst[0]=1;
 		lst[nums.length+1]=1;
 		int[][] dp = new int[nums.length+2][nums.length+2];
 		dp[0][0]=0;
 		for(int len=1;len<=nums.length;len++){
 			for(int i=1;i<=nums.length-len+1;i++){
 				int j= i+len-1;
 				for(int k=i;k<=j;k++){
 					dp[i][j]=Math.max(dp[i][j],lst[i-1]*lst[k]*lst[j+1]+dp[i][k-1]+dp[k+1][j]);
 				}
 			}
 		}
 		return dp[1][nums.length];
    }
}