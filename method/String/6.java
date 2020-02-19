6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

T:O(N)
S:O(N)
建造一個 StringBuilder ArrayList
初始化 
依序加入陣列
碰到 0 OR numRows-1 變方向

class Solution {
    public String convert(String s, int numRows) {
        int len=s.length();
        if(numRows==1) return s;
        
        List<StringBuilder> rows = new ArrayList<> ();
        
        for(int i=0; i<numRows ;i++){
            rows.add(new StringBuilder());
            
        }
        boolean goingDown = false;
        int curRow = 0;
        for(int i=0;i<len;i++){
        rows.get(curRow).append(s.charAt(i));
        if(curRow==0 || curRow==numRows-1){
            goingDown=!goingDown;
        }
        curRow+= goingDown? 1:-1;
 
        }
        
        
        StringBuilder combineTogether = new StringBuilder();
        for(StringBuilder ct:rows){
            combineTogether.append(ct);
        }
        
        return combineTogether.toString();
    }
}