204. Count Primes
Easy

1347

460

Favorite

Share
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.



class Solution {
    public int countPrimes(int n) {
        int c=0;
        boolean[] rec = new boolean[n];
        Arrays.fill(rec,true);
        if(n<2) return 0;
            for (int i=2;i<n;i++){
                
                if(rec[i]==true){
                    
                    for(int j=2;j*i<n;j++){
                        rec[i*j]=false;
                    }
                }
           }
                for(int i=2;i<rec.length;i++)
                    if(rec[i]==true) c++;
                return c;        
    }
    }