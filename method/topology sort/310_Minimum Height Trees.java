310. Minimum Height Trees
Medium

1777

96

Add to List

Share
For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

//time O(N)
//space O(N)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> lst = new ArrayList<>();
        if(edges==null||edges.length==0||edges[0].length==0){
            lst.add(0);
            return lst;
        }
        HashMap<Integer,HashSet<Integer>> nb = new HashMap<>();
        int[] indegree = new int[n];
        for(int[] e:edges){
            nb.putIfAbsent(e[0],new HashSet<>());
            nb.putIfAbsent(e[1],new HashSet<>());
            nb.get(e[0]).add(e[1]);
            nb.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        //topoSort
        //st point 
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
        }
        //lastlevel = good start point
        while(!q.isEmpty()){
            List<Integer> lastLevel = new ArrayList<>();
            for(int size=q.size();size>0;size--){
                int cur = q.poll();
                lastLevel.add(cur);
                for(int next:nb.get(cur)){
                    indegree[next]--;
                    if(indegree[next]==1){
                        q.add(next);
                    }
                }
            }
            lst = lastLevel;
        }
        
        return lst;
    }

}