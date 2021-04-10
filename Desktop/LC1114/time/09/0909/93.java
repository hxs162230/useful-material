93. Restore IP Addresses
Medium

833

357

Favorite

Share
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> lst = new ArrayList<>();
        recur(lst,0,"",s);
        return lst;
    }
    public void recur(List<String> lst,int sep,String out,String s){
        if(sep==4){
            if(s.isEmpty())
                lst.add(out);
                return ;
            }
         
         for(int i=1;i<4;i++){   
            if(s.length()<i) break;
            int val = Integer.parseInt(s.substring(0,i));
            if(val>255 || i!=String.valueOf(val).length()) continue;
            recur(lst,sep+1,out+s.substring(0,i)+(sep==3?"":"."),s.substring(i));
        }

    }
}