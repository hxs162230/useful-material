231. Power of Two

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false

bit operator 在用括號時先刮起來 EX:(n&n-1)==0  
不得用(n&n-1==0) 會出錯

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
//         int a=0;
//         for(int i=0;i<32;i++){
//             if((n&1)==1)
//                 a++;
//             n>>=1;
        
//         }
//         return (a==1?true:false);
        return ((n&n-1)==0?true:false); 
        
    }
}