528. Random Pick with Weight
Medium

373

694

Favorite

Share
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

O(logN)

class Solution {
    int[] sum;
    Random rand;
    public Solution(int[] w) {
        this.sum = new int[w.length];
        this.rand = new Random();
        sum[0]=w[0];
        for(int i=1;i<w.length;i++){
            sum[i]=sum[i-1]+w[i];
        }
        //stem.out.print(sum[sum.length-1]);
    }
    
    public int pickIndex() {
        int left = 0;
        int right = sum.length;
        int x =rand.nextInt(sum[sum.length-1]);
        while(left<right){
            int mid = left+(right-left)/2;
            if(sum[mid]>x) 
                right = mid;
            else
                left = mid+1;
        }
        return right;
    }
}