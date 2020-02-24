38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.


class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        String str = sb.toString();
        
        while(--n>0){
            int count = 1;
            char[]c = str.toCharArray();
            str="";
            int len = c.length;
            for(int i=0;i<len;i++){
                while(i+1<len && c[i]==c[i+1])
                {
                    count++;
                    i++;
                }
                    str+=Integer.toString(count)+c[i];
                    count=1;
            }
        
        }
        return str;
    }
}


sol2:
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        while(--n>0){
            String str = sb.toString();
            char[] cntArr = str.toCharArray();
            int len = cntArr.length;
            int cnt = 1;
            sb.setLength(0);
            for(int i=0;i<len;i++){
                while(i+1<len && cntArr[i]==cntArr[i+1]){
                    cnt++;
                    i++;
                }
                sb.append(String.valueOf(cnt));
                sb.append(cntArr[i]);
                cnt=1;
            }
        }
        return sb.toString();
    }
}



class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while(--n>0){
            char[] c = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int i=0;i<c.length;i++){
                while(i+1<c.length&&c[i]==c[i+1]){
                    cnt++;
                    i++;
                }
                sb.append(String.valueOf(cnt)).append(c[i]);
                cnt = 1;
            }
            str = sb.toString();
        }
        return str;
    }
}