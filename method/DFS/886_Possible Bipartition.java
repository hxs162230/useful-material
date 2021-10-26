886. Possible Bipartition
Medium

946

27

Add to List

Share
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= N <= 2000
0 <= dislikes.length <= 10000
dislikes[i].length == 2
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].

// O(N) time
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        buildGraph(dislikes,map);
        for(int key : map.keySet()){
            //key-1 : 0 base index
            if(colors[key-1]==0&&!dfs(key-1,colors,1,map)) return false;
        }
        return true;
    }
    public void buildGraph(int[][] dislikes,Map<Integer,Set<Integer>> map){
        
        for(int[] d:dislikes){
            map.putIfAbsent(d[0],new HashSet<>());
            map.putIfAbsent(d[1],new HashSet<>());
            map.get(d[0]).add(d[1]);
            map.get(d[1]).add(d[0]);
        }
        
    }
    public boolean dfs(int cur,int[] colors,int color,Map<Integer,Set<Integer>> map){
        //met brfore and return 
        if(colors[cur]!=0) return colors[cur]==color;
        colors[cur] = color;
        //index currection : cur+1
        for(int key : map.get(cur+1)){
            if(!dfs(key-1,colors,-color,map)) return false;
        }
        return true;
    }
}