787. Cheapest Flights Within K Stops
Medium

1028

37

Favorite

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.

There are n cities connected by m flights. Each fight starts from city u and

arrives at v with a price w.

Now given all the cities and flights, together with starting city src and 

the destination dst, your task is to find the cheapest price from src to 

dst with up to k stops. If there is no such route, output -1.

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        //HashSet<Integer> visit = new HashSet<>(src);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});
        for(int[] flight:flights){
            map.putIfAbsent(flight[0],new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int stop =0;
        int res =Integer.MAX_VALUE;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] cur = q.poll();
                if(cur[0]==dst) 
                    res = Math.min(res,cur[1]);
                if(map.get(cur[0])!=null){
                for(int[] nb:map.get(cur[0])){
                   if(nb[1]+cur[1]>res) continue; 
                   q.add(new int[]{nb[0],nb[1]+cur[1]});
                }
                }
            }
            if(stop++>K) break;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}