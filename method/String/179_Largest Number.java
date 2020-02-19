179. Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

这道题给了我们一个数组，让我们将其拼接成最大的数，那么根据题目中给的例子来看，
主要就是要给给定数组进行排序，但是排序方法不是普通的升序或者降序，因为9要排在最前面，
而9既不是数组中最大的也不是最小的，所以我们要自定义排序方法。如果不参考网友的解法，我估计是无法想出来的。
这种解法对于两个数字a和b来说，如果将其都转为字符串，如果ab > ba，则a排在前面，比如9和34，由于934>349，
所以9排在前面，再比如说30和3，由于303<330，所以3排在30的前面。按照这种规则对原数组进行排序后，
将每个数字转化为字符串再连接起来就是最终结果。代码如下：

 

class Solution {
    
    public String largestNumber(int[] nums) {
        
        String[] s =new String[nums.length];
        String res="";
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(s,new largeCmp());
        if(s[0].equals("0"))
            return "0";
        for(int i=0;i<s.length;i++){
            res+=s[i];
        }
        return res;
        
    }
    
}
class largeCmp implements Comparator<String>{
    public int compare(String a,String b){
        String str1=a+b;
        String str2=b+a;
        
        return str2.compareTo(str1);
        
    }
    
    }