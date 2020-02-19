866. Prime Palindrome
Medium

119

350

Favorite

Share
Find the smallest prime palindrome greater than or equal to N.

Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1. 

For example, 2,3,5,7,11 and 13 are primes.

Recall that a number is a palindrome if it reads the same from left to right as it does from right to left. 

For example, 12321 is a palindrome.

 

Example 1:

Input: 6
Output: 7
Example 2:

Input: 8
Output: 11
Example 3:

Input: 13
Output: 101
 

Note:

1 <= N <= 10^8
The answer is guaranteed to exist and be less than 2 * 10^8.

Intuition
Write some example, you find all even digits palindromes are divisible by 11.
So we need to search only palindrome with odd digits.

We can prove as follow:
11 % 11 = 0
1111 % 11 = 0
111111 % 11 = 0
11111111 % 11 = 0

So:
1001 % 11 = (1111 - 11 * 10) % 11 = 0
100001 % 11 = (111111 - 1111 * 10) % 11 = 0
10000001 % 11 = (11111111 - 111111 * 10) % 11 = 0

For any palindrome with even digits:
abcddcba % 11
= (a * 10000001 + b * 100001 * 10 + c * 1001 * 100 + d * 11 * 1000) % 11
= 0



All palindrome with even digits is multiple of 11.
So among them, 11 is the only one prime
if (8 <= N <= 11) return 11

For other cases, we consider only palindrome with odd dights.


Time Complexity
O(10000) to check all numbers 1 - 10000.
isPrime function is O(sqrt(x)) in worst case.
But only sqrt(N) worst cases for 1 <= x <= N
In general it's O(logx)


class Solution {
    public int primePalindrome(int N) {
        if(N>=8&&N<=11) return 11;
        for(int i=1;i<1e5;i++){
            String fst = String.valueOf(i);
            String sec = reverse(fst);
            String com = fst+sec.substring(1);
            int val = Integer.parseInt(com);
            if(val>=N&&isPrime(val)) return val;
        }
        return N;
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false; 
        }
        return true;
    }
}