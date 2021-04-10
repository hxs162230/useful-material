118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lol =new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> lst = new ArrayList<>();
            if(i==0){
                lst.add(1);
                lol.add(lst);
                continue;
            }
            if(i==1){
                lst.add(1);
                lst.add(1);
                lol.add(lst);
                continue;
            }
            lst.add(1);
            for(int j=1;j<i;j++){
              
                lst.add(lol.get(i-1).get(j-1)+(lol.get(i-1).get(j)));
            }            
            lst.add(1);
            lol.add(lst);
        }
        return lol;
    }
}