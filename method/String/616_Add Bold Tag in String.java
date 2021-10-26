616. Add Bold Tag in String
Medium

506

62

Add to List

Share
Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:

Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
 

Example 2:

Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
 

Constraints:

The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
Note: This question is the same as 758: https://leetcode.com/problems/bold-words-in-string/


class Solution {
    int offset = 0;
    public String addBoldTag(String s, String[] dict) {
        List<int[]> lst = new ArrayList<>();
        if(s==null||s.length()==0) return "";
        if(dict.length==0) return s;
        for(String d:dict){
            for(int i=0;i<=s.length()-d.length();i++){
                int idx = s.indexOf(d,i);
                //System.out.println(i+" "+d);
                if(idx!=-1){
                    int end = idx+d.length()-1;
                    lst.add(new int[]{idx,end});
                    i = idx;
                }
                else{
                    break;
                }
                //System.out.println(i+" "+d);
            }
        }
        Collections.sort(lst,(a,b)->(a[0]-b[0]));
        // for(int[] l:lst){
        //     System.out.print(l[0]+" "+l[1]);
        //     System.out.println();
        // }
        
        if(lst.size()==0) return s;
        int st = lst.get(0)[0];
        int ed = lst.get(0)[1];
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=1;i<lst.size();i++){
            if(lst.get(i)[0]>ed+1){
                add(st,ed,sb);
                st = lst.get(i)[0];
                ed = lst.get(i)[1];
            }
            else{
                if(lst.get(i)[1]>ed){
                    ed = lst.get(i)[1];
                }
            }
        }
        //add tag
        add(st,ed,sb);
        return sb.toString();
    }
    public void add(int st,int ed,StringBuilder sb){
        sb.insert(st+offset,"<b>");
        offset+=3;
        sb.insert(ed+1+offset,"</b>");
        offset+=4;
    }

}