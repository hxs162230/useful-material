56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


T:O(NlogN)
S:O(N)

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0||intervals[0].length==0) return new int[0][0];
        int n = intervals.length;
        Arrays.sort(intervals,new cmp());
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=1;i<n;i++){
            if(intervals[i][0]>end){
                addToLst(res,start,end);
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else{
                if(intervals[i][1]>end){
                    end = intervals[i][1];
                }
            }
        }
        addToLst(res,start,end);
        int[][] ans = new int[res.size()][2];
        int idx=0;
        for(List<Integer> l:res){
            ans[idx][0] = l.get(0);
            ans[idx++][1] = l.get(1);
        }
        return ans;
    }
    public void addToLst(List<List<Integer>> res,int st,int ed){
        res.add(Arrays.asList(st,ed));
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]-b[0];
    }
}