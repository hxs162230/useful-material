973. K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

T:O(N)
S:O(1)
partition function排序方法可改寫!
找前K個大或小的問題用 quick select


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points.length==0||points[0].length==0) return new int[0][0];
        int left =0;
        int right = points.length-1;
        while(left<right){
            int pi = partition(points,left,right);
            if(K==pi) break;
            else if(pi<K) left=pi+1;
            else right=pi-1;
        }
        int[][] lst = new int[K][2];
        for(int i=0;i<K;i++){
            lst[i] = points[i];
        }
        return lst;
    }
    public int partition(int[][] points,int left,int right){
        int[] pivot = points[right];
        int low = left-1;
        for(int i=left;i<right;i++){
            if(points[i][0]*points[i][0]+points[i][1]*points[i][1]<pivot[0]*pivot[0]+pivot[1]*pivot[1]){
                low++;
                swap(points,low,i);
            }
        }
        swap(points,low+1,right);
        return low+1;
    }
    public void swap(int[][] arr,int a,int b ){
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}