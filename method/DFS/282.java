282. Expression Add Operators
Hard

870

123

Favorite

Share
Given a string that contains only digits 0-9 and a target value, 

return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

这道题给了我们一个只由数字组成的字符串，让我们再其中添加+,-或*号来形成一个表达式，
该表达式的计算和为给定了target值，让我们找出所有符合要求的表达式来。看了题目中的例子1和2，很容易让人误以为是必须拆成个位数字，其实不是的，
比如例子3中的 "105", 5能返回"10-5"，说明连着的数字也可以。
如果非要在过往的题中找一道相似的题，我觉得跟 Combination Sum II 很类似。不过这道题要更复杂麻烦一些。
还是用递归来解题，我们需要两个变量diff和curNum，一个用来记录将要变化的值，
另一个是当前运算后的值，而且它们都需要用 long 型的，因为字符串转为int型很容易溢出，
所以我们用长整型。对于加和减，diff就是即将要加上的数和即将要减去的数的负值，而对于乘来说稍有些复杂，
此时的diff应该是上一次的变化的diff乘以即将要乘上的数，有点不好理解，那我们来举个例子，比如 2+3*2，即将要运算到乘以2的时候，上次循环的 curNum = 5, diff = 3, 而如果我们要算这个乘2的时候，新的变化值diff应为 3*2=6，而我们要把之前+3操作的结果去掉，再加上新的diff，即 (5-3)+6=8，即为新表达式 2+3*2 的值，有点难理解，大家自己一步一步推算吧。

还有一点需要注意的是，如果输入为"000",0的话，容易出现以下的错误：

Wrong：["0+0+0","0+0-0","0+0*0","0-0+0","0-0-0","0-0*0","0*0+0","0*0-0","0*0*0","0+00","0-00","0*00","00+0","00-0","00*0","000"]

Correct：["0*0*0","0*0+0","0*0-0","0+0*0","0+0+0","0+0-0","0-0*0","0-0+0","0-0-0"]

我们可以看到错误的结果中有0开头的字符串出现，明显这不是数字，所以我们要去掉这些情况，过滤方法也很简单，我们只要判断长度大于1且首字符是‘0’的字符串，将其滤去即可，参见代码如下

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> lst = new ArrayList<>();
        dfs(num,target,0,0,"",lst);
        return lst;
    }
    public void dfs(String s,int target,long diff,long sum,String out,List<String> lst){
        if(s.isEmpty()&&target == sum){
            lst.add(out);
            return;
        }
        for(int i=1;i<=s.length();i++){
            String cur = s.substring(0,i);
            if(cur.length()>1&&cur.charAt(0)=='0') continue;
            String next = s.substring(i);
            if(out.length()>0){
                dfs(next,target,Long.parseLong(cur),sum+Long.parseLong(cur),out+"+"+cur,lst);
                dfs(next,target,-Long.parseLong(cur),sum-Long.parseLong(cur),out+"-"+cur,lst);
                dfs(next,target,diff*Long.parseLong(cur),sum-diff+diff*Long.parseLong(cur),out+"*"+cur,lst);
            }
            else{
                dfs(next,target,Long.parseLong(cur),Long.parseLong(cur),cur,lst);
            }
        }
    }
}