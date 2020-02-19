246. Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false

由于满足题意的数字不多，所以我们可以用哈希表来做，把所有符合题意的映射都存入哈希表中，
然后双指针扫描，看对应位置的两个数字是否在哈希表里存在映射，若不存在，
返回false，遍历完成返回true，参见代码如下：

 

class Solution {
    public boolean isStrobogrammatic(String num) {
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        int left=0;
        int right=num.length()-1;
        while(left<=right){
            if(!map.containsKey(num.charAt(left))) return false;
            if(map.get(num.charAt(left))!=num.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}