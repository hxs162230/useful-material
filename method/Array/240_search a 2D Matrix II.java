240. Search a 2D Matrix II
Medium

1984

60

Favorite

Share
Write an efficient algorithm that searches for a value in an m x n matrix. 

This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:


Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

T:O(M+N)
//每一列最後一個不小於下一列第一個   => 不好做Binary search

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        
        int row=matrix.length;
        int col=matrix[0].length;
        int right=0,up=row-1;
        //int iniPoint = matrix[up][right];
        
        while(right<col && up>=0){
            
            int iniPoint = matrix[up][right];
            if(target == iniPoint) return true;
            else if (target> iniPoint) right++;
            else up--;
        }
        
        return false;
    }
}