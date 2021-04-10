253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


T:O(NlogN)
S:O(N)
維護 heap 
存時間END time
當時間不重疊=>pq.poll()
最後得出最少需要多少個房間

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0||intervals[0].length<2) return 0;
        Arrays.sort(intervals,new cmp());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            if(!pq.isEmpty()&&intervals[i][0]>=pq.peek())
                pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]-b[0];
    }
}