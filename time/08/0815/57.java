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