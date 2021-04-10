332. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.


这道题给我们一堆飞机票，让我们建立一个行程单，
如果有多种方法，取其中字母顺序小的那种方法。这道题的本质是有向图的遍历问题，
那么LeetCode关于有向图的题只有两道Course Schedule和Course Schedule II，
而那两道是关于有向图的顶点的遍历的，而本题是关于有向图的边的遍历。
每张机票都是有向图的一条边，我们需要找出一条经过所有边的路径，
那么DFS不是我们的不二选择。先来看递归的结果，我们首先把图建立起来，通过邻接链表来建立。
由于题目要求解法按字母顺序小的，那么我们考虑用multiset，可以自动排序。等我们图建立好了以后，
从节点JFK开始遍历，只要当前节点映射的multiset里有节点，我们取出这个节点，将其在multiset里删掉，然后继续递归遍历这个节点，
由于题目中限定了一定会有解，那么等图中所有的multiset中都没有节点的时候，我们把当前节点存入结果中，然后再一层层回溯回去，
将当前节点都存入结果，那么最后我们结果中存的顺序和我们需要的相反的，我们最后再翻转一下即可，参见代码如下：


like TopologySort 
T:O(V+E)
S:O(V+E)

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> lst= new LinkedList<>();
        for(List<String> ticket:tickets){
            if(!map.containsKey(ticket.get(0))) map.put(ticket.get(0),new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK",map,lst);
        return lst;
    }
    public void dfs(String s,HashMap<String,PriorityQueue<String>> map,LinkedList<String> lst){
         PriorityQueue<String> pq = map.get(s);
         while(pq!=null&&!pq.isEmpty()){
             dfs(pq.poll(),map,lst);
         }
        lst.addFirst(s);
    }
}