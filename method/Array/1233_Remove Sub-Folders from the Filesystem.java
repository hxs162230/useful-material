1233. Remove Sub-Folders from the Filesystem
Medium

200

40

Add to List

Share
Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.

If a folder[i] is located within another folder[j], it is called a sub-folder of it.

The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.

 

Example 1:

Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
Example 2:

Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
Example 3:

Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 

Constraints:

1 <= folder.length <= 4 * 10^4
2 <= folder[i].length <= 100
folder[i] contains only lowercase letters and '/'
folder[i] always starts with character '/'
Each folder name is unique.




I think the time complexity for method 2 is actually O(n * m * logn) and do not need to simplify.
Because the sort is based on merge sort for Object and time complexity of merge sort is O(n * logn). That means n * logn times comparing happened.
For this question, it just makes the comparing time be O(m). Thus it won't increase the number of "layers" of merge sort to log(n * m).


class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> lst = new ArrayList<>();
        for(String f:folder){
            if(!lst.isEmpty()&&f.startsWith(lst.get(lst.size()-1)+"/")){
                continue;
            }
            lst.add(f); 
        }
        return lst;
    }
}