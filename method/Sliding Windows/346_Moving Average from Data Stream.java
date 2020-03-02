346. Moving Average from Data Stream
Easy

379

44

Favorite

Share
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

class MovingAverage {
    Deque<Integer> dq = new LinkedList<>();
    int cap = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.cap = size;
    }
    
    public double next(int val) {
        dq.addLast(val);
        sum+=val;
        if(dq.size()>cap) sum-=dq.pollFirst();
        return (double) sum/dq.size();
    }
}




/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */