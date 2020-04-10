692. Top K Frequent Words
Medium

1321

114

Add to List

Share
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> lst = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
        public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b){
            return (a.getValue()!=b.getValue()?b.getValue()-a.getValue():a.getKey().compareTo(b.getKey()));
        }     
        });
        for(String word:words){
            if(!map.containsKey(word))
                map.put(word,1);
            else
                map.put(word,map.get(word)+1);
        }
        for(Map.Entry<String,Integer> m:map.entrySet()){
            pq.add(m);
        
        }
        for(int i=k;i>0;i--){
            if(pq.peek()==null) break;
            lst.add(pq.poll().getKey());
        }
        return lst;
    }
}



class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
        (a,b)->(a.getValue()!=b.getValue()?a.getValue()-b.getValue():b.getKey().compareTo(a.getKey()))
        );
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        for(Map.Entry<String,Integer> m:map.entrySet()){
            pq.add(m);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()) res.add(pq.poll().getKey());
        Collections.reverse(res);
        return res;
    }
}