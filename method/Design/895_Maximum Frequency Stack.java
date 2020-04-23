895. Maximum Frequency Stack
Hard

784

13

Add to List

Share
Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].
 

Note:

Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
The total number of FreqStack.push calls will not exceed 10000 in a single test case.
The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 

if (m.get(maxfreq).size() == 0) maxfreq--; 这个厉害了，主要是HashMap<Integer, Stack> m = new HashMap<>(); 这个数据结构用的比较巧妙。比如5，3，5，5 这个将是
1 <5,3>
2 <5>
3 <5>

 class FreqStack {
    HashMap<Integer,Integer> f = new HashMap<>();
    HashMap<Integer,Stack<Integer>> map = new HashMap<>();
    int maxfreq = 0;
    public FreqStack() {
        
    }
    public void push(int x) {
        int k = f.getOrDefault(x,0)+1;
        maxfreq = Math.max(maxfreq,k);
        f.put(x,k);
        
        map.putIfAbsent(k,new Stack<>());
        map.get(k).push(x);
    }
    
    public int pop() {
        int k =  map.get(maxfreq).pop();
        f.put(k,maxfreq-1);
        if(map.get(maxfreq).size()==0) maxfreq--;
        return k;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */