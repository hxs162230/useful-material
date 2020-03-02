406. Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. 

Each person is described by a pair of integers (h, k),

where h is the height of the person and k is the number of people in front of this person 

who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 input =>  70    71   61   50    52    44 => insert into arrayList => output
这道题给了我们一个队列，队列中的每个元素是一个 pair，
分别为身高和前面身高不低于当前身高的人的个数，让我们重新排列队列，
使得每个 pair 的第二个参数都满足题意。首先来看一种超级简洁的方法，给队列先排个序，
按照身高高的排前面，如果身高相同，则第二个数小的排前面。然后新建一个空的数组，
遍历之前排好序的数组，
然后根据每个元素的第二个数字，将其插入到 res 数组中对应的位置，参见代码如下：

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new cmp());
        List<int[]> lol = new ArrayList<>();
        for(int[] person:people){
            lol.add(person[1],new int[]{person[0],person[1]});
        }
        int[][] res = new int[lol.size()][2];
        int i=0;
        for(int[] person:lol){
            res[i++]=person;
        }
        return res;
    }
}
class cmp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];
    }
}