975. Odd Even Jump

You are given an integer array A.  From some starting index, you can make a series of jumps.  The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.

You may from index i jump forward to index j (with i < j) in the following way:

During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
(It may be the case that for some index i, there are no legal jumps.)
A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)

Return the number of good starting indexes.


We need to jump higher and lower alternately to the end.

Take [5,1,3,4,2] as example.

If we start at 2,
we can jump either higher first or lower first to the end,
because we are already at the end.
higher(2) = true
lower(2) = true

If we start at 4,
we can't jump higher, higher(4) = false
we can jump lower to 2, lower(4) = higher(2) = true

If we start at 3,
we can jump higher to 4, higher(3) = lower(4) = true
we can jump lower to 2, lower(3) = higher(2) = true

If we start at 1,
we can jump higher to 2, higher(1) = lower(2) = true
we can't jump lower, lower(1) = false

If we start at 5,
we can't jump higher, higher(5) = false
we can jump lower to 4, lower(5) = higher(4) = false

class Solution {
    public int oddEvenJumps(int[] A) {
        int len = A.length;
        boolean[] odd = new boolean[len];
        boolean[] even = new boolean[len];
        odd[len-1]=true;
        even[len-1]=true;
        int ans = 1;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(A[len-1],len-1);
        for(int i=len-2;i>=0;i--){
            Integer greater = map.ceilingKey(A[i]); 
            Integer lower = map.floorKey(A[i]); return greatest key lessthan or equal to A[i]
            if(greater!=null){
                odd[i]=even[map.get(greater)];
            }
            if(lower!=null){
                even[i]=odd[map.get(lower)];
            }
            if(odd[i])
                ans++;
            map.put(A[i],i);
        }
        return ans;
    }
}