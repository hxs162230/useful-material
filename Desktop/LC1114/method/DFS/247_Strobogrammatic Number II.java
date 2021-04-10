247. Strobogrammatic Number II

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]

这道题是之前那道Strobogrammatic Number的拓展，那道题让我们判断一个数是否是对称数，而这道题让我们找出长度为n的所有的对称数，
我们肯定不能一个数一个数的来判断，那样太不高效了，而且OJ肯定也不会答应。题目中给了提示说可以用递归来做，而且提示了递归调用n-2，
而不是n-1。我们先来列举一下n为0,1,2,3,4的情况：

n = 0:   none

n = 1:   0, 1, 8

n = 2:   11, 69, 88, 96

n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986

n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966

我们注意观察n=0和n=2，可以发现后者是在前者的基础上，每个数字的左右增加了[1 1], [6 9], [8 8], [9 6]，看n=1和n=3更加明显，
在0的左右增加[1 1]，变成了101, 在0的左右增加[6 9]，变成了609, 在0的左右增加[8 8]，变成了808, 在0的左右增加[9 6]，变成了906, 
然后在分别在1和8的左右两边加那四组数，我们实际上是从m=0层开始，一层一层往上加的，需要注意的是当加到了n层的时候，左右两边不能加[0 0]，
因为0不能出现在两位数及多位数的开头，在中间递归的过程中，需要有在数字左右两边各加上0的那种情况，参见代码如下：  

//postorder 


class Solution {
    public List<String> findStrobogrammatic(int n) {
        return recur(n,n);
    }
    public List<String> recur(int n,int m){
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));
        List<String> lst = recur(n-2,m);
        List<String> res = new ArrayList<>();
        for(String s:lst){
            if(n!=m) 
                res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }
}

class Solution {
    int m;
    HashMap<Integer,List<String>> cache = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        m=n;
        return dfs(n);
    }
    public List<String> dfs(int n){
        if(n==0) return new ArrayList<>(Arrays.asList(""));
        if(n==1) return new ArrayList<>(Arrays.asList("0","1","8"));
        if(cache.containsKey(n)) return cache.get(n); 
        List<String> lst = dfs(n-2);
        List<String> res = new ArrayList<>();
        for(String s:lst){
            if(n!=m)
                res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        cache.put(n,res);
        return res;
    }
}