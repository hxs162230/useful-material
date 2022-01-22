274. H-Index
Medium

1109

1720

Add to List

Share
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.

 

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
 

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000






class Solution {

     // First we order the values of f from the largest to the lowest value. Then, we look for the last        position in which f is greater than or equal to the position (we call h this position).

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i : citations){
            if(i>n){
                buckets[n]++;
            }
            else{
                buckets[i]++;
            }
        }

        // for(int i:buckets){
        //     System.out.print(i+" ");
        // }
        int idx = 0;
        
	//to find last valid index, we traverse backward 
	for(int i=buckets.length-1;i>=0;i--){
            idx+=buckets[i];
            if(idx>=i) return i;
        }
        return 0;
    }
}
