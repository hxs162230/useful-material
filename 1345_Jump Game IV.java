1345. Jump Game IV
Hard

552

41

Add to List

Share
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
Example 4:

Input: arr = [6,1,9]
Output: 2
Example 5:

Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.putIfAbsent(arr[i],new HashSet<>());
            graph.get(arr[i]).add(i);
        }
        
        int target = n-1;
        boolean[] seen = new boolean[n];
        HashSet<Integer> q1 = new HashSet<>();
        q1.add(0);
        seen[0] = true;
        HashSet<Integer> q2 = new HashSet<>();
        q2.add(target);
        int step = 0;
        seen[target] = true;
        while(!q1.isEmpty()||!q2.isEmpty()){
            if(q1.size()>q2.size()){
                HashSet<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int next : q1){    
                graph.get(arr[next]).add(next+1);
                graph.get(arr[next]).add(next-1);
                for(int nb : graph.get(arr[next])){
                    if(nb>=n||nb<0) continue;
                    if(q2.contains(nb)) return step+1;
                    if(seen[nb]) continue;
                    set.add(nb);
                    seen[nb] = true;
                }
            }
            step++;
            q1 = set;
        }
        
        return -1;
    }
}