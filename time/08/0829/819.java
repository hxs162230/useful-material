class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] word = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        String str = "";
        for(String w:word){
            if(!map.containsKey(w))
                map.put(w,1);
            else
                map.put(w,map.get(w)+1);
        }
        for(String b:banned){
            //System.out.println(b);
            if(map.containsKey(b))
                map.remove(b);
        }
        
        for(String m:map.keySet()){
             //System.out.print(m);
            int value = map.get(m);
            if(value>max) {
                str=m;
                max=value;
            }
        }
        return str;
    }
}