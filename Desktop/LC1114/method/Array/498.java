498. Diagonal Traverse
Medium

451

261

Favorite

Share
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return new int[0];
        int rlen = matrix.length;
        int clen = matrix[0].length;
        int[] res = new int[rlen*clen];
        for(int id=0,i=0,j=0;id<rlen*clen;id++){
                res[id]=matrix[i][j];
                if((i+j)%2==0){
                    if(i-1>=0&&j+1<clen){
                        i-=1;
                        j+=1;
                    }
                    else if(i-1<0&&j+1<clen){
                        j+=1;
                    }
                    else if(j+1>clen-1)
                        i+=1;
                }
                else{
                    if(j-1>=0&&i+1<rlen){
                        j-=1;
                        i+=1;
                    }
                    else if(i+1<rlen&&j-1<0){
                        i+=1;
                    }
                    else if(i+1>rlen-1){
                        j+=1;
                    }
                }
            
        }
        return res;
    }
}