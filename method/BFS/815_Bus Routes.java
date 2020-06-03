815. Bus Routes
Hard

649

21

Add to List

Share
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 

Constraints:

1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5.
0 <= routes[i][j] < 10 ^ 6.


class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        if(n==0) return 0;
        //node,bus_route# set
        HashMap<Integer,HashSet<Integer>> map =new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j:routes[i]){
                //put(routes[i][j],set)  length not equal each row
                map.putIfAbsent(j,new HashSet<Integer>());
                map.get(j).add(i);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        //start,bus stop# pair
        q.add(new int[]{S,0});
        HashSet<Integer> seen = new HashSet<>();
        boolean[] routeSeen = new boolean[n];
        seen.add(S);
        while(!q.isEmpty()){
            int cur = q.peek()[0];
            int num = q.peek()[1];
            q.poll();
            if(cur==T) return num;
            //level order
            if(map.containsKey(cur))
            for(int i:map.get(cur)){
                if(routeSeen[i]) continue;
                //in this level we iterator each node
                for(int j:routes[i]){
                    if(seen.contains(j)) continue;
                    seen.add(j);
                    q.add(new int[]{j,num+1});
                }
                routeSeen[i] = true;
            }
        }
        return -1;
    }
}