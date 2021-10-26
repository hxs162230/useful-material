992. Subarrays with K Different Integers
Hard

1509

26

Add to List

Share
Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

 

Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Note:

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
Accepted
39,303
Submissions
77,818


class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A,K) - atMostKDistinct(A,K-1);
    }
    
    public int atMostKDistinct(int[] A,int K){
        if(K==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int cnt = 0;
        while(right<A.length){
            map.put(A[right],map.getOrDefault(A[right],0)+1);
            while(map.size()>K){
                map.put(A[left],map.get(A[left])-1);
                if(map.get(A[left])==0){ 
                    map.remove(A[left]);
                }
                left++;
            }
            cnt+=right-left+1;
            right++;
        }
        
        return cnt;
    }
    
}