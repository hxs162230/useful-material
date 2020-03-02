636. Exclusive Time of Functions

On a single threaded CPU, we execute some functions.  

Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  

or example, "0:start:3" means the function with id 0 started at the beginning of 

timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function. 

Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a 

given time unit.

Return the exclusive time of each function, sorted by their function id.

 

Example 1:



Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 

Note:

1 <= n <= 100
Two functions won't start or end at the same time.
Functions will always log when they exit.
 
函数开启了就压入栈，结束了就出栈，不会有函数被漏掉。这样的我们可以遍历每个log，
然后把三部分分开，函数idx，类型type，时间点time。如果此时栈不空，说明之前肯定有函数在跑，
那么不管当前时start还是end，之前函数时间都得增加，增加的值为time - preTime，
这里的preTime是上一个时间点。然后我们更新preTime为当前时间点time。然后我们判断log的类型，
如果是start，我们将当前函数压入栈；
如果是end，那么我们将栈顶元素取出，对其加1秒，并且preTime也要加1秒，参见代码如下：


 class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] arr = new int[n];
        int prevTime = 0;
        for(String log:logs){
            String[] p = log.split("\\:");
            if(!stk.isEmpty()) arr[stk.peek()]+=Integer.parseInt(p[2])-prevTime;
            prevTime = Integer.parseInt(p[2]);
            if(p[1].equals("start"))
                stk.push(Integer.parseInt(p[0]));
            else{
                arr[stk.pop()]++;
                prevTime++;
            }
        }
        return arr;
    }
}