588. Design In-Memory File System

Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, 

return a list that only contains this file's name. 

If it is a directory path, return the list of file and directory names in this directory. 

Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, 

you should make a new directory according to the path. 

If the middle directories in the path don't exist either, you should create them as well. 

This function has void return type.

addContentToFile: Given a file path and file content in string format. 

If the file doesn't exist, 

you need to create that file containing given content. 

If the file already exists, you need to append given content to original content. 

This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

 

Example:

Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

Output:
[null,[],null,null,["a"],"hello"]

Explanation:
filesystem
 

Note:

You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.


class FileSystem {
    HashMap<String,Set<String>> dirs = new HashMap<>();
    HashMap<String,String> file = new HashMap<>();

    public FileSystem() {
        dirs.put("/",new TreeSet<>());
    }
    
    public List<String> ls(String path) {
        int idx = path.lastIndexOf("/");
        String name = path.substring(idx+1);
        if(file.containsKey(name)){
            List<String> lst = new ArrayList<>();
            lst.add(name);
            return lst;
        }
        return new ArrayList<>(dirs.get(path));
    }
    
    public void mkdir(String path) {
        String[] p = path.split("/");
        String dir = "";
        for(int i=1;i<p.length;i++){
            String t = p[i];
            if(dir.length()==0) dir+="/";
            if(dirs.containsKey(dir)) dirs.get(dir).add(t);
            if(dir.length()>1) dir+="/";
            dir+=t;
            dirs.putIfAbsent(dir,new TreeSet<>());
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        int idx = filePath.lastIndexOf("/");
        String dir = filePath.substring(0,idx);
        String filename = filePath.substring(idx+1);
        if(dir.length()==0) dir+="/";
        if(!dirs.containsKey(dir)) mkdir(dir);
        if(dirs.containsKey(dir)) dirs.get(dir).add(filename);
        file.putIfAbsent(filename,"");
        file.put(filename,file.get(filename)+content);
    }
    
    public String readContentFromFile(String filePath) {
        int idx = filePath.lastIndexOf("/");
        String filename = filePath.substring(idx+1);
        return file.get(filename);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */