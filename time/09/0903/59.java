59. Spiral Matrix II
Medium

630

91

Favorite

Share
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

class Solution {
    public int[][] generateMatrix(int n) {
        if(n<=0) return new int[0][0];
        int[][] arr =new int[n][n];
        int left=0;
        int right=n-1;
        int up=0;
        int low=n-1;
        int num=1;
        while(true){
            for(int j=left;j<=right;j++){
                arr[up][j]=num++;
            }
            if(++up>low) break;
            for(int i=up;i<=low;i++){
                arr[i][right]=num++;
            }
            if(--right<left) break;
            for(int j=right;j>=left;j--){
                arr[low][j]=num++;
            }
            if(--low<up) break;
            for(int i=low;i>=up;i--){
                arr[i][left]=num++;
            }
            if(++left>right) break;
            
            
        }
        return arr;
    }
}