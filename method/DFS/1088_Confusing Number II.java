1088. Confusing Number II
Hard

125

48

Add to List

Share
We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.

A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)

Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.

 

Example 1:

Input: 20
Output: 6
Explanation: 
The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.
Example 2:

Input: 100
Output: 19
Explanation: 
The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 

Note:

1 <= N <= 10^9





//time O(5^64)
//space O(64)
class Solution {
    HashMap<Integer,Integer> map;
    int count = 0;
    public int confusingNumberII(int N) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(N,0);
        return count;
    }
    public void dfs(int N,long num){
        if(isConf(num)){
            count++;
        }
        for(int i:map.keySet()){
            if(num*10+i<=N&&num*10+i>=1){
                dfs(N,num*10+i);
            }
        }
    }
    public boolean isConf(long N){
        long num = N;
        long res = 0;
        while(num!=0){
            int d = (int)num%10;
            //if(res>Long.MAX_VALUE/10) return false;
            if(!map.containsKey(d)) return false;
            d = map.get(d);
            res= res*10 + d;
            num/=10;
        }
        return res!=N;
    }
}