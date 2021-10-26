862. Shortest Subarray with Sum at Least K
Hard

853

24

Add to List

Share
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.

 

Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3
 

Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9

why no two pointer ? we have negative values here!!!!

class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length+1];
        for(int i=1;i<=A.length;i++){
            sum[i] = sum[i-1]+A[i-1];
        }
        Deque<Integer> deq = new LinkedList<>();
        int min = A.length+1;
        for(int i=0;i<=A.length;i++){
            while(!deq.isEmpty()&&sum[i]-sum[deq.peekFirst()]>=K){
                min = Math.min(min,i-deq.pollFirst());
            }
//             Why keep the deque increase?
//             If B[i] <= B[d.back()] and moreover we already know that i > d.back(), 
//             it means that compared with d.back(),
//             B[i] can help us make the subarray length shorter and sum bigger. 
//             So no need to keep d.back() in our deque.
            // sum[i]  -  sum[deq.peekLast()] <=0
            while(!deq.isEmpty()&&sum[i]<=sum[deq.peekLast()]){
                deq.pollLast();
            }
            deq.add(i);
        }
        return min==A.length+1?-1:min;
    }
}


