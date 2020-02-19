1192. Critical Connections in a Network

There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

< Tarjan Algorithm is used for finding all strongly connected components in a graph.>

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] low = new int[n];
        int[] time = new int[n];
        Arrays.fill(time,-1);
        List<Integer>[] nblst = new ArrayList[n];
        for(int i=0;i<n;i++){
            nblst[i] = new ArrayList<>();
        }
        for(List<Integer> con:connections){
            int from = con.get(0);
            int to = con.get(1);
            nblst[from].add(to);
            nblst[to].add(from);
        }
        for(int i=0;i<n;i++){
            if(time[i]==-1){
                dfs(res,nblst,low,time,i,i);
            }
        }
        return res;
    }
    int stamp=0;
    public void dfs(List<List<Integer>> res,List<Integer>[] nblst,int[] low,int[] time,int cur, int pre){
        low[cur] = time[cur] = ++stamp;
        for(int i=0;i<nblst[cur].size();i++){
            int next = nblst[cur].get(i);
            if(next==pre) continue;
            if(time[next]==-1){
                dfs(res,nblst,low,time,next,cur);
                low[cur] = Math.min(low[cur],low[next]);
                if(low[next]>time[cur]){
                    res.add(Arrays.asList(cur,next));
                }
            }
            else{
                low[cur] = Math.min(low[cur],time[next]);
            }
        }
    }
}

// Basically, it uses dfs to travel through the graph to find if current vertex u, can travel back to u or previous vertex
// low[u] records the lowest vertex u can reach
// disc[u] records the time when u was discovered

// public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
// 	int[] disc = new int[n], low = new int[n];
// 	// use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
// 	List<Integer>[] graph = new ArrayList[n];
// 	List<List<Integer>> res = new ArrayList<>();
// 	Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
// 	for (int i = 0; i < n; i++) {
// 		graph[i] = new ArrayList<>();
// 	}
// 	// build graph
// 	for (int i = 0; i < connections.size(); i++) {
// 		int from = connections.get(i).get(0), to = connections.get(i).get(1);
// 		graph[from].add(to);
// 		graph[to].add(from);
// 	}

// 	for (int i = 0; i < n; i++) {
// 		if (disc[i] == -1) {
// 			dfs(i, low, disc, graph, res, 0);
// 		}
// 	}
// 	return res;
// }

// int time = 0; // time when discover each vertex

// private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
// 	disc[u] = low[u] = ++time; // discover u
// 	for (int j = 0; j < graph[u].size(); j++) {
// 		int v = graph[u].get(j);
// 		if (v == pre) {
// 			continue; // if parent vertex, ignore
// 		}
// 		if (disc[v] == -1) { // if not discovered
// 			dfs(v, low, disc, graph, res, u);
// 			low[u] = Math.min(low[u], low[v]);
// 			if (low[v] > disc[u]) {
// 				// u - v is critical, there is no path for v to reach back to u or previous vertices of u
// 				res.add(Arrays.asList(u, v));
// 			}
// 		} else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
// 			low[u] = Math.min(low[u], disc[v]);
// 		}
// 	}
// }

Critical Router:
root and child 

class Solution {
    int root=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] low = new int[n];
        int[] time = new int[n];
        Arrays.fill(time,-1);
        
        List<Integer>[] nblst = new ArrayList[n];
        for(int i=0;i<n;i++){
            nblst[i] = new ArrayList<>();
        }
        for(List<Integer> con:connections){
            int from = con.get(0);
            int to = con.get(1);
            nblst[from].add(to);
            nblst[to].add(from);
        }
        for(int i=0;i<n;i++){
            if(time[i]==-1){
                root=i;
                dfs(res,nblst,low,time,i,i);
            }
        }
        return res;
    }
    int stamp=0;
    public void dfs(List<List<Integer>> res,List<Integer>[] nblst,int[] low,int[] time,int cur, int pre){
        low[cur] = time[cur] = ++stamp;
        int child=0;
        for(int i=0;i<nblst[cur].size();i++){
            int next = nblst[cur].get(i);
            if(next==pre) continue;
            if(time[next]==-1){
                child++;
                dfs(res,nblst,low,time,next,cur);
                low[cur] = Math.min(low[cur],low[next]);
                if((child>1&&root==cur)||(root!=cur&&low[next]>time[cur])){
                    res.add(Arrays.asList(cur));
                }
            }
            else{
                low[cur] = Math.min(low[cur],time[next]);
            }
        }
    }
}