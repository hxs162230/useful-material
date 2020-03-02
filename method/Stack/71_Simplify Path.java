71. Simplify Path
Medium

534

1398

Favorite

Share
Given an absolute path for a file (Unix-style), simplify it. 

Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. 

Furthermore, a double period .. moves the directory up a level. 

For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, 

and there must be only a single slash / between two directory names. 

The last directory name (if it exists) must not end with a trailing /. 

Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"

这道题让简化给定的路径，
光根据题目中给的那一个例子还真不太好总结出规律，应该再加上两个例子
 path = "/a/./b/../c/", => "/a/c"和path = "/a/./b/c/", => "/a/b/c"， 
 这样我们就可以知道中间是"."的情况直接去掉，是".."时删掉它上面挨着的一个路径，
 而下面的边界条件给的一些情况中可以得知，如果是空的话返回"/"，如果有多个"/"只保留一个。
 那么我们可以把路径看做是由一个或多个"/"分割开的众多子字符串，把它们分别提取出来一一处理即可，
 代码如下：

 
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] dir = path.split("/");
        StringBuilder sb = new StringBuilder("/");
        for(String sd:dir){
            if(!stk.isEmpty() && sd.equals("..")){
                stk.pop();
            }
            else if(!sd.equals("") && !sd.equals(".")&& !sd.equals("..")){
                stk.push(sd);
            }
        }
        for(String s:stk){
            sb.append(s+"/");
        }
        if(!stk.isEmpty()) sb.setLength(sb.length()-1); 
        
        return sb.toString();
        
    }
}