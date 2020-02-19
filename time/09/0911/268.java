那么思路是既然0到n之间少了一个数，我们将这个少了一个数的数组合0到n之间完整的数组异或一下，
那么相同的数字都变为0了，剩下的就是少了的那个数字了，参加代码如下：
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans^=(i+1)^nums[i];
            
        }
        return ans;
        
    }
}