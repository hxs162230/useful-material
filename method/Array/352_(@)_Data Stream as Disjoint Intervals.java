352. Data Stream as Disjoint Intervals
Hard

301

81

Add to List

Share
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
 

Follow up:

What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
进一步思考：

如果合并次数非常多，与数据流的规模相比不相交区间的数目很少，应当做怎样的优化？

解题思路：
利用TreeSet数据结构，将不相交区间Interval存储在TreeSet中。

TreeSet底层使用红黑树实现，可以用log(n)的代价实现元素查找。

每次执行addNum操作时，利用TreeSet找出插入元素val的左近邻元素floor（start值不大于val的最大Interval），以及右近邻元素higher（start值严格大于val的最小Interval）

然后根据floor, val, higher之间的关系决定是否对三者进行合并。



class SummaryRanges {
    TreeMap<Integer,Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
         map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer upper = map.higherKey(val);
        Integer lower = map.lowerKey(val);
        if(upper!=null&&lower!=null&&map.get(lower).end+1==val&&val+1==upper){
           map.get(lower).end = map.get(upper).end;
           map.remove(upper);
        }
        else if(lower!=null&&map.get(lower).end+1>=val){
            map.get(lower).end = Math.max(val,map.get(lower).end);
        }
        else if(upper!=null&&val+1==upper){
            map.put(val,new Interval(val,map.get(upper).end));
            map.remove(upper);
        }
        else{
            map.put(val,new Interval(val,val));
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        
        int i=0;
        for(Interval m:map.values()){
            //System.out.println(m.st+"@"+m.end);
            res[i][0] = m.st;
            res[i++][1] = m.end;
        }
        return res;
    }
    class Interval{
        int st;
        int end;
        public Interval(int st,int end){
            this.st = st;
            this.end = end;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */