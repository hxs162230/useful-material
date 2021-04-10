296. Best Meeting Point
Hard

344

24

Favorite

Share
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example:

Input: 

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 6 

Explanation: Given three people living at (0,0), (0,4), and (2,2):
             The point (0,2) is an ideal meeting point, as the total travel distance 
             of 2+2+2=6 is minimal. So return 6.

那么我们可以发现，只要开会为位置P在 [A, B] 区间内，不管在哪，距离之和都是A和B之间的距离，
如果P不在 [A, B] 之间，那么距离之和就会大于A和B之间的距离，那么我们现在再加两个点C和D：

______C_____A_____P_______B______D______

我们通过分析可以得出，P点的最佳位置就是在 [A, B] 区间内，这样和四个点的距离之和为AB距离加上 CD 距离，
在其他任意一点的距离都会大于这个距离，那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，
然后用最后一个坐标减去第一个坐标，即 CD 距离，倒数第二个坐标减去第二个坐标，即 AB 距离，
以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可，参见代码如下：

T:O(MN)
S:O(MN)


class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                   row.add(i);
                   col.add(j);
               }
            }
        }
        //Collections.sort(row);
        Collections.sort(col);
        int res=0;
        int start=0;
        int end=row.size()-1;
        while(start<end){
            res+=row.get(end)-row.get(start)+col.get(end--)-col.get(start++);
        }
        return res;
    }
}