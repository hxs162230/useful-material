261. Graph Valid Tree
Medium

902

31

Add to List

Share
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.



class Solution {
    int[] pre;
    int[] h;
    public boolean validTree(int n, int[][] edges) {
        pre = new int[n];
        h = new int[n];
        int s = n;
        for(int i=0;i<n;i++) {
            pre[i] = i;
            h[i] = 0;
        }
        for(int[] e:edges){
            int n1 = e[0];
            int n2 = e[1];
            int pre1 = findpre(n1);
            int pre2 = findpre(n2);
            if(pre1!=pre2){
                union(pre1,pre2);
                s--;
            }
            else return false;
        }
        return s==1;
    }
    
    
    public void union(int i,int j){
        int pre1 = findpre(i);
        int pre2 = findpre(j);
        
        if(h[pre1]<h[pre2]){
            pre[pre1] = pre2;
        }
        else if(h[pre1]>h[pre2]){
            pre[pre2] = pre1;
        }
        else{
            pre[pre1] = pre2;
            ++h[pre2];
        }
    }
    
    
    public int findpre(int x){
        if(pre[x]==x) return x;
        return pre[x] = findpre(pre[x]);
    }
    
    
}