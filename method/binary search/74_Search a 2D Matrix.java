74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0,right=row*col-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[mid/col][mid%col]==target) return true;
            else if(matrix[mid/col][mid%col]<target) left=mid+1;
            else right=mid-1;
            
            
        }
        return false;
    }
}