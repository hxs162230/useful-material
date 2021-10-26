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

There are n cities connected by m flights. 

Each fight starts from city u and

arrives at v with a price w.

Now given all the cities and flights, together with starting city src and 

the destination dst, your task is to find the cheapest price from src to 

dst with up to k stops. If there is no such route, output -1.

這是另一種最短路徑的解法(包含存入QUEUE以及MAP的製作)
把DISTANCE資料一併放入QUEUE, 取出時自帶資訊

不求全局最短,只求K步內最短
不必relaxation
做變種bfs

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
                   if(nb[1]+cur[1]>res) continue; !!!!!!!!!!!!!!!!!!666666
                   q.add(new int[]{nb[0],nb[1]+cur[1]});
                }
                }
            }
            if(stop++>K) break;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}



Some explanation.
The key difference with the classic Dijkstra algo is, we don't maintain the global optimal distance to each node, i.e. ignore below optimization:
alt ← dist[u] + length(u, v)
if alt < dist[v]:
Because there could be routes which their length is shorter but pass more stops, and those routes don't necessarily constitute the best route in the end. To deal with this, rather than maintain the optimal routes with 0..K stops for each node, the solution simply put all possible routes into the priority queue, so that all of them has a chance to be processed. IMO, this is the most brilliant part.
And the solution simply returns the first qualified route, it's easy to prove this must be the best route.



class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer,HashSet<int[]>> map = new HashMap<>();
        for(int[] f:flights){
            map.putIfAbsent(f[0],new HashSet<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        q.add(new int[]{0,src,K+1});
        
        while(!q.isEmpty()){
            for(int size=q.size();size>0;size--){
                int[] t = q.poll();
                int curNode = t[1];
                int rStop = t[2];
                int minD = t[0];
                if(curNode==dst) return minD;
                if(rStop<=0) continue;
                if(map.containsKey(curNode))
                for(int[] next:map.get(curNode)){
                    //if(next[1]+minD>=minD) continue;
                    q.add(new int[]{next[1]+minD,next[0],rStop-1});
                }
            }

        }
        return -1;
    }
}