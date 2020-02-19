class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        List<Integer> lst=new ArrayList<>();
        if (s.length()<=0 || words.length == 0 || words[0].length() == 0) return lst;
        int len=words[0].length();
        for(String s1:words){
            if(!hm.containsKey(s1))
            hm.put(s1,1);
            else
            hm.put(s1,hm.get(s1)+1);
        }
        for(int i=0;i<=s.length()-len*words.length;i++){
            Map<String, Integer> copy = new HashMap<String, Integer>(hm);
            for(int j=0;j<words.length;j++){
                String str=s.substring(i+j*len,i+j*len+len); //nextword
                //System.out.println(str);
                if(copy.containsKey(str)){
                        copy.put(str,copy.get(str)-1);
                    if(copy.get(str)==0)
                        copy.remove(str);
                    if(copy.isEmpty()){
                       // System.out.println(str);
                        lst.add(i);
                        break;
                    }      
                }
                else
                break;
            }
        }
        return lst;
    }
}