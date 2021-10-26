FileSearch.java

package com.mkyong;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

  private String fileNameToSearch;
  private List<String> result = new ArrayList<String>();
    
  public String getFileNameToSearch() {
    return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
    this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
    return result;
  }

  public static void main(String[] args) {

    FileSearch fileSearch = new FileSearch();
  
        //try different directory and filename :)
    fileSearch.searchDirectory(new File("/Users/mkyong/websites"), "post.php");

    int count = fileSearch.getResult().size();
    if(count ==0){
        System.out.println("\nNo result found!");
    }else{
        System.out.println("\nFound " + count + " result!\n");
        for (String matched : fileSearch.getResult()){
        System.out.println("Found : " + matched);
        }
    }
  }

  public void searchDirectory(File directory, String fileNameToSearch) {

    setFileNameToSearch(fileNameToSearch);

    if (directory.isDirectory()) {
        search(directory);
    } else {
        System.out.println(directory.getAbsoluteFile() + " is not a directory!");
    }

  }

  private void search(File file) {

    if (file.isDirectory()) {
      System.out.println("Searching directory ... " + file.getAbsoluteFile());
        
            //do you have permission to read this directory?	
        if (file.canRead()) {
        for (File temp : file.listFiles()) {
            if (temp.isDirectory()) {
            search(temp);
            } else {
            if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {			
                result.add(temp.getAbsoluteFile().toString());
            }

        }
        }

     } else {
        System.out.println(file.getAbsoluteFile() + "Permission Denied");
     }
      }

  }

}




class File {
    String name;
    int size;
    int type;
    boolean isDirectory;
    File[] children;
}

abstract class Filter {
    abstract boolean apply(File file);
}

class MinSizeFilter extends Filter {

    int minSize;

    public MinSizeFilter(int minSize) {
        this.minSize = minSize;
    }

    @Override
    boolean apply(File file) {
        return file.size > minSize;
    }
}

class TypeFilter extends Filter {

    int type;

    public TypeFilter(int type) {
        this.type = type;
    }

    @Override
    boolean apply(File file) {
        return file.type == type;
    }
}

class FindCommand {

    public List<File> findWithFilters(File directory, List<Filter> filters) {
        if (!directory.isDirectory) {
            return new NotADirectoryException();
        }
        List<File> output = new ArrayList<>();
        findWithFilters(directory, filters, output);
        return output;
    }

    private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
        if (directory.children == null) {
            return;
        }
        for (File file : directory.children) {
            if (file.isDirectory) {
                findWithFilters(file, filters, output);
            } else {
                boolean selectFile = true;
                for (Filter filter : filters) {
                    if (!filter.apply(file)) {
                        selectFile = false;
                    }
                }
                if (selectFile) {
                    output.add(file);
                }
            }
        }
    }
}