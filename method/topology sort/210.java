210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pre:prerequisites){
            if(!map.containsKey(pre[1]))
                map.put(pre[1],new HashSet<Integer>());
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        List<Integer> lst = new ArrayList<>();
        
        while(!q.isEmpty()){
            int tmp = q.peek();
            q.poll();
            lst.add(tmp);
            if(map.get(tmp)!=null){
                for(int i:map.get(tmp)){
                    indegree[i]--;
                    if(indegree[i]==0)
                        q.add(i);
                }
            }
        }
        if(lst.size()!=numCourses)
            lst.clear();
        int[] order = new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            order[i]=lst.get(i);
        }
        return order;
    }
}