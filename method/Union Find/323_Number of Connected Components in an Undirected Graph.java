323. Number of Connected Components in an Undirected Graph
Medium

749

20

Add to List

Share
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] node = new int[n];
        int[] height = new int[n];
        for(int i=0;i<n;i++) node[i] = i;
        
        for(int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];
            int root1 = findRoot(v1,node);
            int root2 = findRoot(v2,node);
            if(root1!=root2){
                union(root1,root2,node,height);
                n--;        
            }
        }
        return n;
        
    }
    public void union(int root1,int root2,int[] root,int[] height){
        // int root1 = findRoot(i,root);
        // int root2 = findRoot(j,root);
        // if(root1==root2) return ;
        if(height[root1]>height[root2]){
            root[root2] = root1;
        }
        else if(height[root1]<height[root2]){
            root[root1] = root2;
        }
        else{
            root[root1] = root2;
            height[root2]++;
        }
    }
    public int findRoot(int x,int[] root){
        if(root[x]==x) return x;
        return root[x] = findRoot(root[x],root);
    }
}