class HitCounter {
    int[] hits;
    int[] times;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp%300;
        if(times[idx]!=timestamp){
            times[idx]=timestamp;
            hits[idx]=1;
        }
        else
            hits[idx]++;
 
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
           int numOfhits = 0;
        for(int i=0;i<300;i++){
            if(timestamp-times[i]<300)
                numOfhits+=hits[i];
        }
        return numOfhits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */