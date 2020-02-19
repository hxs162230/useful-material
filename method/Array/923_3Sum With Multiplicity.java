923. 3Sum With Multiplicity

Given an integer array A, and an integer target, 

return the number of tuples i, j, k  such that i < j < k 

and A[i] + A[j] + A[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.


Example 1:

Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (A[i], A[j], A[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: A = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
 

Note:

3 <= A.length <= 3000
0 <= A[i] <= 100
0 <= target <= 300
T:O(N) in copying array
T:O(100*100) = O(1); in computing sum combinations;
S:O(100)


class Solution {
    public int threeSumMulti(int[] A, int target) {
        if(A.length<3) return 0;
        int modulo = 1000000007;
        long[] buckets = new long[101];
        long res=0;
        for(int a: A){
            buckets[a]++;
        }
        for(int i=0;i<=100;i++){
            for(int j=i;j<=100;j++){
                int k=target-i-j;
                if(k<0 || k>100 || k<j) continue;
                if(i==j && j==k){
                  res+=buckets[i]*(buckets[i]-1)*(buckets[i]-2)/6;  
                }
                else if(i==j && j!=k){
                  res+=buckets[i]*(buckets[i]-1)*buckets[k]/2;  
                }
                else if(i!=j && j==k){
                  res+=buckets[j]*(buckets[j]-1)*buckets[i]/2;  
                }
                else{
                  res+=buckets[i]*(buckets[j])*(buckets[k]);
                }
            }
        }
        
        return (int)(res%modulo);
    }
}