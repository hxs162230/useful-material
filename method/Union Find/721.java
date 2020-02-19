721. Accounts Merge
Medium

844

222

Favorite

Share
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

这个归组类的问题，最典型的就是岛屿问题(例如 Number of Islands II)，很适合使用 Union Find 来做，
LeetCode 中有很多道可以使用这个方法来做的题，比如 Friend Circles，Graph Valid Tree，Number of
Connected Components in an Undirected Graph，和 Redundant Connection 等等。
都是要用一个 root 数组，每个点开始初始化为不同的值，如果两个点属于相同的组，
就将其中一个点的 root 值赋值为另一个点的位置，这样只要是相同组里的两点，
通过 find 函数得到相同的值。在这里，由于邮件是字符串不是数字，所以 root 可以用 HashMap 来代替，
还需要一个 HashMap 映射owner，
建立每个邮箱和其所有者姓名之前的映射，另外用一个 HashMap 来建立用户和其所有的邮箱之间的映射
，也就是合并后的结果。
首先遍历每个账户和其中的所有邮箱，先将每个邮箱的 root 映射为其自身，
然后将 owner 赋值为用户名。然后开始另一个循环，遍历每一个账号，
首先对帐号的第一个邮箱调用 find 函数，得到其父串p，然后遍历之后的邮箱，
对每个遍历到的邮箱先调用 find 函数，将其父串的 root 值赋值为p，
这样做相当于将相同账号内的所有邮箱都链接起来了。接下来要做的就是再次遍历每个账户内的所有邮箱，
先对该邮箱调用 find 函数，找到父串，然后将该邮箱加入该父串映射的集合汇总，这样就就完成了合并。
最后只需要将集合转为字符串数组，加入结果 res 中，通过 owner 映射找到父串的用户名，加入字符串数组的首位置
，参见代码如下：


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> lol = new ArrayList<List<String>>();
        HashMap<String,String> root = new HashMap<>();
        HashMap<String,String> owner = new HashMap<>();
        HashMap<String,Set<String>> map = new HashMap<>();
        for(List<String> account:accounts){
            for(int i=1;i<account.size();i++){
                root.put(account.get(i),account.get(i));
                owner.put(account.get(i),account.get(0));
            }
        }
        for(List<String> account:accounts){
            String p = find(account.get(1),root);
            for(int i=2;i<account.size();i++){
                root.put(find(account.get(i),root),p);
            }
        }
        for(List<String> acc:accounts){
            String p = find(acc.get(1),root);
            if(!map.containsKey(p)) map.put(p,new TreeSet<>());
            for(int i=1;i<acc.size();i++){
                map.get(p).add(acc.get(i));
            }
        }
        for(String s:map.keySet()){
            List<String> email = new ArrayList<>(map.get(s));
            email.add(0,owner.get(s));
            lol.add(email);
        }
        return lol;
    }
    public String find(String s,HashMap<String,String> root){
        return root.get(s)==s?s:find(root.get(s),root);
    }
}
