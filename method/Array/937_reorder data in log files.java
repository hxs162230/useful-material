937. Reorder Data in Log Files

You have an array of logs.  

Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  

Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  

It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  

The letter-logs are ordered lexicographically ignoring identifier, 

with the identifier used in case of ties.  

The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

T:O(NlogN)
S:O(1)
1.compareTo()的用法
2.compare return -1 <= 順序對   不用換
          return +1 <= 順序錯   要換位
          return 0  維持原本順序
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,new cmp());
        return logs;
    }
}
class cmp implements Comparator<String>{
    public int compare(String a,String b){
        String[] f = a.split("\\ ",2);
        String[] s = b.split("\\ ",2);
        boolean one = Character.isDigit(f[1].charAt(0));
        boolean two = Character.isDigit(s[1].charAt(0));
        if(!one&&!two){
            int k = f[1].compareTo(s[1]);
            if(k==0) return f[0].compareTo(s[0]);
            return k;
        }
        return (one?(two?0:1):-1);
    }
}

// class cmp implements Comparator<String>{
//     public int compare(String a,String b){
//         String[] fst = a.split(" ",2);
//         String[] sec = b.split(" ",2);
//         boolean b1 =Character.isDigit(fst[1].charAt(0));
//         boolean b2 =Character.isDigit(sec[1].charAt(0));
//         if(!b1&&!b2){
//             int k=fst[1].compareTo(sec[1]);
//             if(k==0) return fst[0].compareTo(sec[0]);
//             return k;
//         }
//         return b1?(b2?0:1):-1;
            
//     }
// }