57. Insert Interval
Hard

1243

143

Add to List

Share
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        int start=newInterval[0];
        int end =newInterval[1];
        int idx=0;
        for(;idx<intervals.length;idx++){
            if(intervals[idx][1]<start){
                addint(lol,intervals[idx][0],intervals[idx][1]);
            }
            else if(intervals[idx][0]>end){
                break;
            }
            else{
                start = Math.min(start,intervals[idx][0]);
                end = Math.max(end,intervals[idx][1]);
            }
        }
        addint(lol,start,end);
        for(;idx<intervals.length;idx++){
            addint(lol,intervals[idx][0],intervals[idx][1]);
        }
        int[][] arr =new int[lol.size()][2];
        int i=0;
        for(List<Integer> a:lol){
            arr[i][0]=a.get(0);
            arr[i][1]=a.get(1);
            i++;
        }
        return arr;
    }
    public void addint(List<List<Integer>> lol,int start,int end){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(start);
        arr.add(end);
        lol.add(arr);
        return;
    }
}