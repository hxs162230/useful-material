54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

T:O(MN)
S:O(MN)
維持邊界 當違反邊界條件則 break


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0) return lst;
        int row=matrix.length;
        int col=matrix[0].length;
        int up=0;
        int left=0;
        int down=row-1;
        int right=col-1;
        
        while(true){
            for(int i=left;i<=right;i++){
                lst.add(matrix[up][i]);
            }
            if(++up>down) break;
            for(int i=up;i<=down;i++){
                lst.add(matrix[i][right]);
            }
            if(--right<left) break;
            for(int i=right;i>=left;i--){
                lst.add(matrix[down][i]);
            }
            if(--down<up) break;
            for(int i=down;i>=up;i--){
                lst.add(matrix[i][left]);
            }
            if(++left>right) break;
        }
        return lst;
    }
}