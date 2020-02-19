313. Super Ugly Number

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.
Note:

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

T:O(n*primes.length)
S:O(N)
於之前所存之第K個 ugly number ，並設置primes.length個指針進行運算

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] buckets = new int[n];
        buckets[0]=1;
        int[] idx = new int[primes.length];
      
        
        for(int i=1;i<n;i++){
            int number = Integer.MAX_VALUE;                           數字越來越大 number要重新initialize
            for(int j=0;j<primes.length;j++){
                 number = Math.min(number,primes[j]*buckets[idx[j]]);
            }
            for(int j=0;j<primes.length;j++){
                if(number == primes[j]*buckets[idx[j]])
                    idx[j]++;
            }
            buckets[i] = number;
        }
        return buckets[n-1];
    }
}