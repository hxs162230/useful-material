class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] wkrs = new int[workers.length];
        Arrays.fill(wkrs,-1);
        //distance workeridx bikeidx
        PriorityQueue<int[]> pq = new PriorityQueue<>(new cmp()); 
        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                int dis = Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1]);
                pq.add(new int[]{dis,i,j});
            }
        }
        HashSet<Integer> bikeIdx = new HashSet<>();
        for(int i=0;i<bikes.length;i++) bikeIdx.add(i);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(wkrs[cur[1]]==-1&&bikeIdx.contains(cur[2])){
                 wkrs[cur[1]]=cur[2];
                 bikeIdx.remove(cur[2]);
            }
        }
        return wkrs;
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return (a[0]==b[0]?(a[1]==b[1]?a[2]-b[2]:a[1]-b[1]):a[0]-b[0]);
    }
}