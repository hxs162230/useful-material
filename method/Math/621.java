621. Task Scheduler
Medium

2079

388

Favorite

Share
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

这道题好在没有让我们输出任务安排结果，而只是问所需的时间总长，
那么我们就想个方法来快速计算出所需时间总长即可。我们仔细观察上面两个例子可以发现，
都分成了(mx - 1)块，再加上最后面的字母，其中mx为最大出现次数。比如例子1中，A出现了4次，
所以有A---模块出现了3次，再加上最后的A，每个模块的长度为4。例子2中，CE-出现了2次，再加上最后的CE，
每个模块长度为3。我们可以发现，模块的次数为任务最大次数减1，模块的长度为n+1，
最后加上的字母个数为出现次数最多的任务，可能有多个并列。这样三个部分都搞清楚了，写起来就不难了，
我们统计每个大写字母出现的次数，然后排序，这样出现次数最多的字母就到了末尾，然后我们向前遍历，
找出出现次数一样多的任务个数，就可以迅速求出总时间长了，
面这段代码可能最不好理解的可能就是最后一句了，那么我们特别来讲解一下。
先看括号中的第二部分，前面分析说了mx是出现的最大次数，
mx-1是可以分为的块数，n+1是每块中的个数，而后面的 25-i 是还需要补全的个数，用之前的例子来说明：


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char task:tasks){
            cnt[task-'A']++;
        }
        Arrays.sort(cnt);
        int i=25;
        int mx=cnt[25];
        while(i>=0 && mx==cnt[i]) i--;
        int res = Math.max(tasks.length,(mx-1)*(n+1)+25-i);
        return res;
    }
}