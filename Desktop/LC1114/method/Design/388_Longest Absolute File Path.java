388. Longest Absolute File Path


Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png

下面这种方法用到了字符串流机制，通过 getline() 函数可以一行一行的获取数据，
实际上相当于根据回车符 \n 把每段分割开了，然后对于每一行，我们找最后一个空格符 \t 的位置，
然后可以得到文件或文件夹的名字，然后我们判断其是文件还是文件夹，如果是文件就更新 res，
如果是文件夹就更新 HashMap 的映射，参见代码如下：
当前深度下的文件的绝对路径就是文件名长度加上 HashMap 中当前深度对应的长度

class Solution {
    public int lengthLongestPath(String input) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int res=0;
        for(String s:input.split("\n")){
            int level = s.lastIndexOf("\t")+1;
            int len = s.length() - level;
            if(s.contains(".")){
                res=Math.max(res,map.get(level)+len);   		當等於file 更新長度
            }
            else{
                map.put(level+1,map.get(level)+len+1); //+1='/' 存下一層的長度
            }
        }
        return res;
    }
}