1231. Divide Chocolate
Hard

270

19

Add to List

Share
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

 

Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.
Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 

Constraints:

0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5

In this problem we want to find: Maximum of minimum total sweetness
In "Split Array Largest sum" we want to find: Minimum of maximum largest sum

In both places we do binary search on target answer, the difference is subtle but the key:

In this when we overshoot the target, we will include that number in previous sum, 
as that is how we will maintain the target as the minimum number and binary search will find this optimal minimum
In "Split Array Largest sum" when we overshoot the target, we will include the number in the next sum, so we can ensure all numbers are less than target - binary search does the rest of the magic
Regarding people's questions on why the binary search target is guaranteed to be the answer is because if there is a better optimal answer binary search will keep heading to it, can prove by contradiction


此題 max of min 與 split array largest sum (min of max) 略有不同
    先加sum                                 後加sum(不超過)


class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int n = sweetness.length;
        int[] pre = new int[n+1];
        
        
        
        int right = 0;
        int left =1;
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1]+sweetness[i-1];
            //left = Math.max(left,sweetness[i-1]);
        }
        right = pre[n];
        
        while(left<right){
            int m = left+(right-left)/2;
            if(!isValid(m,sweetness,K)){
                left = m+1;
            }
            else{
                right = m;
            }
        }
        return right;
    }
    public boolean isValid(int cap, int[] s, int K){
        int num = 1;
        int sum = 0;
        for(int i:s){
            sum+=i;
            if(sum>cap){
                num++;
                sum = 0;
                if(num>K+1) return false;
            }
            
        }
        return true;
    }
}