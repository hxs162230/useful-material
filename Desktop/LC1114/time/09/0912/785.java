785. Is Graph Bipartite?
Medium

848

112

Favorite

Share
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

所谓二分图，就是可以将图中的所有顶点分成两个不相交的集合，
使得同一个集合的顶点不相连。为了验证是否有这样的两个不相交的集合存在，
我们采用一种很机智的染色法，大体上的思路是要将相连的两个顶点染成不同的颜色，
一旦在染的过程中发现有两连的两个顶点已经被染成相同的颜色，
说明不是二分图。这里我们使用两种颜色，分别用1和 -1 来表示，
初始时每个顶点用0表示未染色，然后遍历每一个顶点，
如果该顶点未被访问过，则调用递归函数，如果返回 false，那么说明不是二分图，
则直接返回 false。如果循环退出后没有返回 false，则返回 true。在递归函数中，
如果当前顶点已经染色，如果该顶点的颜色和将要染的颜色相同，则返回 true，否则返回 false。
如果没被染色，则将当前顶点染色，然后再遍历与该顶点相连的所有的顶点，调用递归函数，如果返回 false 了
，则当前递归函数的返回 false，循环结束返回 true，参见代码如下：

 


class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0 && !dfsColor(graph,i,colors,1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfsColor(int[][] graph,int i,int[] colors,int color){
        if(colors[i]!=0) return colors[i]==color; 
        colors[i] = color;
        for(int adj:graph[i]){
            if(!dfsColor(graph,adj,colors,-1*color))
                return false;
        }
        return true;
    }
}