477. Total Hamming Distance
Medium

1493

74

Add to List

Share
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
The answer for the given input will fit in a 32-bit integer.


Hint:
Because we will only care how many combinations of 1 and 0 in the current bit among all numbers. n - bitCount will tell us the number of zeroes. So that the bitCount(number of ones) * (n - bitCount) will give us the number of bits differences for current bit. :)


class Solution {
    public int totalHammingDistance(int[] nums) {
        int conbinations = 0;
        int totalBitSet = 0;
        for(int i=0;i<32;i++){
            totalBitSet = 0;
            for(int num:nums){
                int currentBit = (num>>i)&1;
                totalBitSet+=currentBit;
            }
            conbinations+=(totalBitSet)*(nums.length-totalBitSet);
        }
        return conbinations;
    }
}
