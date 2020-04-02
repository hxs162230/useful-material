1135. Connecting Cities With Minimum Cost
Medium

210

10

Add to List

Share
There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.

 

Example 1:



Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.
Example 2:



Input: N = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: 
There is no way to connect all cities even if all edges are used.
 

Note:

1 <= N <= 10000
1 <= connections.length <= 10000
1 <= connections[i][0], connections[i][1] <= N
0 <= connections[i][2] <= 10^5
connections[i][0] != connections[i][1]


class Solution {
    int[] pre;
    int n;
    public void union(int x,int y){
        int root1 = find(x);
        int root2 = find(y);
        if(root1!=root2){
            pre[root2] = root1;
            n--;
        }
    }
    public int find(int x){
        if(pre[x]==x) return x;
        return pre[x] = find(pre[x]);
    }
    public int minimumCost(int N, int[][] connections) {
        this.pre = new int[N+1];
        this.n = N;
        for(int i=0;i<=N;i++) pre[i] = i;
        Arrays.sort(connections, (a,b)->(a[2]-b[2]));
        // for(int[] c:connections)
        // System.out.println(c[2]);
        int costs = 0;
        for(int[] conn:connections){
            int a = conn[0];
            int b = conn[1];
            if(find(a)!=find(b)){
                costs+=conn[2];
                union(a,b);
            }
        }
        
        return n==1?costs:-1;
    }
}


class Solution {
    int[] pre;
    int[] height;
    int n;
    public void union(int x,int y){
        int root1 = find(x);
        int root2 = find(y);
        if(root1==root2) return;
        
        if(height[root1]>height[root2]){
             pre[root2] = root1;
        }
        else if(height[root1]<height[root2]){
             pre[root1] = root2;
        }
        else{
             pre[root1] = root2;
             ++height[root2];   
        }
        --n;
    }
    public int find(int x){
        if(pre[x]==x) return x;
        return pre[x] = find(pre[x]);
    }
    public int minimumCost(int N, int[][] connections) {
        this.pre = new int[N+1];
        this.height = new int[N+1];
        this.n = N;
        for(int i=0;i<=N;i++){
            pre[i] = i;
            height[i] = 0;
        }
        
        Arrays.sort(connections, (a,b)->(a[2]-b[2]));
        // for(int[] c:connections)
        // System.out.println(c[2]);
        int costs = 0;
        for(int[] conn:connections){
            int a = conn[0];
            int b = conn[1];
            if(find(a)!=find(b)){
                costs+=conn[2];
                union(a,b);
            }
        }
        
        return n==1?costs:-1;
    }
}