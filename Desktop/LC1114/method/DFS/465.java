465. Optimal Account Balancing
Hard

320

48

Favorite

Share
A group of friends went on holiday and sometimes lent each other money. 

For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.

T:O(N!)

class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] trans:transactions){
            map.put(trans[0],map.getOrDefault(trans[0],0)-trans[2]);
            map.put(trans[1],map.getOrDefault(trans[1],0)+trans[2]);
        }
        int idx=0;
        int[] trans = new int[map.size()];
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()!=0){
                trans[idx++] = m.getValue();
            }
        }
        return dfs(trans,idx,0,0);
    }
    public int dfs(int[] trans,int n,int start,int num){
        int res = Integer.MAX_VALUE;
        while(start<n && trans[start]==0){
            start++;
        }
        for(int i=start+1;i<n;i++){
            if(trans[i]*trans[start]<0){
                trans[i]+=trans[start];
                res = Math.min(res,dfs(trans,n,start+1,num+1));
                trans[i]-=trans[start];
            }
        }
        return res==Integer.MAX_VALUE?num:res;
    }
}