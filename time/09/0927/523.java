523. Continuous Subarray Sum

Given a list of non-negative numbers and a target integer k, write a function to check 

if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, 

that is, sums up to n*k where n is also an integer.

 

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 

Note:

The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

既然set可以做，一般来说用哈希表也可以做，这里我们建立余数和当前位置之间的映射，由于有了位置信息，
我们就不需要pre变量了，之前用保存的坐标和当前位置i比较判断就可以了，参见代码如下：
We iterate through the input array exactly once, keeping track of the running 
sum mod k of the elements in the process. 
If we find that a running sum value at index j has been previously seen before 
in some earlier index i in the array, then we know that the sub-array (i,j] contains a desired sum.
 

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int t=(k==0)?sum:sum%k;
            if(map.containsKey(t)){
                if(i-map.get(t)>1) return true;
            }
            else{
                map.put(t,i);
            }
        }
        return false;
    }
}