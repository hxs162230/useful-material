670. Maximum Swap

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

下面这种解法建了十个桶，分别代表数字0到9，每个桶存该数字出现的最后一个位置，
也就是低位。这样从开头开始遍历数字上的每位上的数字，然后从大桶开始遍历，
如果该大桶的数字对应的位置大于当前数字的位置，说明低位的数字要大于当前高位上的数字，
那么直接交换这两个数字返回即可，其实核心思路跟上面的解法蛮像的，参见代码如下：

class Solution {
    public int maximumSwap(int num) {
        char[] number = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];
        for(int i=0;i<number.length;i++){
            bucket[(number[i]-'0')] = i;
        }
        for(int i=0;i<number.length;i++){
            for(int j=9;j>number[i]-'0';j--){
                if(bucket[j]>i){
                    swap(number,i,bucket[j]);
                    return Integer.parseInt(String.valueOf(number));
                }
            }
        }
        return num;
        
    }
    public void swap(char[] number,int i,int j){
        char tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }
}