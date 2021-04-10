277. Find the Celebrity

Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 

The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: 

"Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

 

Example 1:


Input: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
Example 2:


Input: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
Output: -1
Explanation: There is no celebrity.
 

Note:

The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means person i knows person j while a[i][j] = 0 means the contrary.
Remember that you won't have direct access to the adjacency matrix.

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

下面这种方法是网上比较流行的一种方法，设定候选人 res 为0，原理是先遍历一遍，对于遍历到的人i，若候选人 res 认识i，则将候选人 res 设为i，完成一遍遍历后，我们来检测候选人 res 
是否真正是名人，我们如果判断不是名人，则返回 -1，如果并没有冲突，返回 res，参见代码如下：

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        for(int i=0;i<n;i++){
            if(knows(ans,i)) ans=i;
        }
        for(int i=0;i<n;i++){
            if(i!=ans && (!knows(i,ans) || knows(ans,i)))
                return -1;
        }
        return ans;
    }
}