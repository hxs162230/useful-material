1245. Tree Diameter
Medium

214

5

Add to List

Share
Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.

The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.

 

Example 1:



Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: 
A longest path of the tree is the path 1 - 0 - 2.
Example 2:



Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: 
A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 

Constraints:

0 <= edges.length < 10^4
edges[i][0] != edges[i][1]
0 <= edges[i][j] <= edges.length
The given edges form an undirected tree.

time O(N)
space O(N^2)

class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length+1;
        if(n==0) return 0;
        List<Integer>[] nblst = new ArrayList[n];
        for(int i=0;i<n;i++) nblst[i] = new ArrayList<>();
        for(int[] e:edges){
            nblst[e[0]].add(e[1]);
            nblst[e[1]].add(e[0]);
        }
        //return (max,endPoint) set
        int[] endPoint = bfs(n,nblst,0);

        return bfs(n,nblst,endPoint[1])[0];
    }
    public int[] bfs(int n,List<Integer>[] nblst,int start){
        int[] res = new int[2];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
               int cur = q.poll();
               int d = dist[cur];
                for(int nb:nblst[cur]){
                    if(d+1<dist[nb]){
                        dist[nb] = d+1;
                        q.add(nb);
                    }
                }
            }
        }
        int endPoint = -1;
        int max = 0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]>max){
                max = dist[i];
                endPoint = i;
            }
        }
        res[0] = max;
        res[1] = endPoint;
        return res;
    }
}
