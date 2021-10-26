743. Network Delay Time

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as 

directed edges times[i] = (u, v, w), where u is the source node, 

v is the target node, and w is the time it takes 

for a signal to travel from source to target.

Now, we send a signal from a certain node K. 

How long will it take for all nodes to receive the signal? 

If it is impossible, return -1.

 

Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

普通的实现方法的时间复杂度为 O(V^2)，

基于优先队列的实现方法的时间复杂度为 O(E + VlogV)，

其中V和E分别为结点和边的个数，这里多说一句，Dijkstra 

Dijkstra 算法这种类贪心算法的机制，使得其无法处理有负权重的最短距离，

还好这道题的权重都是正数，参见代码如下：


class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] edge = new int[101][101];
        for(int[] edg:edge) Arrays.fill(edg,-1);
        
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        for(int i=0;i<times.length;i++){
            edge[times[i][0]][times[i][1]] = times[i][2];
        }
        while(!q.isEmpty()){
            HashSet<Integer> visit = new HashSet<>();
            for(int i=q.size();i>0;i--){
                int t = q.poll();
                for(int k=1;k<=100;k++){
                    int d = edge[t][k];
                    if(d!=-1 && distance[t]+d<distance[k]){
                        if(!visit.contains(k)){
                            visit.add(k);
                            q.add(k);
                        }
                        distance[k] = distance[t]+d;
                    }
                }
            }
        }
        int res=0;
        for(int i=1;i<=N;i++){
            res=Math.max(res,distance[i]);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] edge = new int[101][101];
        for(int[] edg:edge) Arrays.fill(edg,-1);
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        for(int i=0;i<times.length;i++){
            edge[times[i][0]][times[i][1]] = times[i][2];
        }
        while(!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int t = q.poll();
                for(int k=1;k<=100;k++){
                    int d = edge[t][k];
                    if(d!=-1 && distance[t]+d<distance[k]){    
                        q.add(k);
                        distance[k] = distance[t]+d;
                    }
                }
            }
        }
        int res=0;
        for(int i=1;i<=N;i++){
            res=Math.max(res,distance[i]);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}



class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[101][101];
        for(int[] d:graph) Arrays.fill(d,-1);
        for(int[] t:times){
            graph[t[0]][t[1]] = t[2];        
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        q.add(new int[]{0,K});
        while(!q.isEmpty()){
            int[] t = q.poll();
            int curNode = t[1];
            int curD = dist[curNode];
            for(int i=1;i<=100;i++){
                if(i!=curNode&&graph[curNode][i]!=-1){
                    if(curD+graph[curNode][i]<dist[i]){
                        q.add(new int[]{curD+graph[curNode][i],i});
                        dist[i] = curD + graph[curNode][i];
                    }
                }
            }
        }
        
        int maxLen = 0;
        for(int i=1;i<=N;i++){
            maxLen=Math.max(dist[i],maxLen);
        }
        return maxLen==Integer.MAX_VALUE?-1:maxLen;
    }
}

// Bellman-Ford  O(NN)   單點最短
// Floyd-Warshall O(NNN) 多點最短
// FW為BF的extention 
// 
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N];
        Arrays.fill(dist,100*101);
        dist[K-1] = 0;
        for(int i=1;i<N;i++){
            for(int[] time:times){
                int st = time[0]-1;
                int ed = time[1]-1;
                int wd = time[2];
                dist[ed] = Math.min(dist[ed],dist[st]+wd);
            }
        }
        int max = 0;
        for(int d:dist){
            max = Math.max(d,max);
        }
        return max==100*101?-1:max;
    }
}



class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dist = new int[N][N];
        int maxdist = 100*101;
        for(int[] d:dist) Arrays.fill(d,100*101);
        for(int i=0;i<N;i++) dist[i][i] = 0;
        for(int[] time:times){
            int st = time[0]-1;
            int ed = time[1]-1;
            int wd = time[2];
            dist[st][ed] = wd;
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        
        int max = 0;
        for(int d:dist[K-1]){
            max = Math.max(max,d);
        }
        return max==maxdist?-1:max;
    }
}