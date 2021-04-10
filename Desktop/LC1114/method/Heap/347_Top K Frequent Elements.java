347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.



(NlogN)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> q=new PriorityQueue<>(new cmp());
        List<Integer> lst=new ArrayList<>();
        for(int num:nums){
            if(!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num,map.get(num)+1);
        }
        for(Map.Entry<Integer,Integer> max : map.entrySet()){
            q.add(max);
        }
        for(int i=1;i<=k;i++){
            
            lst.add(q.poll().getKey());
        }
        return lst;
    }
}
class cmp implements Comparator<Map.Entry<Integer,Integer>> {
    public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
     return b.getValue()-a.getValue();   
    }
}
(Nlogk)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new cmp());
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            pq.add(m);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            lst.add(pq.poll().getKey());
        }
        return lst;
    
    }
    
}
class cmp implements Comparator<Map.Entry<Integer,Integer>>{
    public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
        return a.getValue()-b.getValue();
    }
}

