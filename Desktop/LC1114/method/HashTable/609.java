class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> lol = new ArrayList<List<String>>();
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(String path:paths){
            String[] str = path.split("\\s+");
            for(int i=1;i<str.length;i++){
                int idx = str[i].indexOf("(");
                String content = str[i].substring(idx);
                String filepath = str[0] + "/" + str[i].substring(0,idx);
                if(!map.containsKey(content))
                    map.put(content,new ArrayList<>());
                map.get(content).add(filepath);       
            }
        }
        for(String key:map.keySet()){
            if(map.get(key).size()>1) lol.add(map.get(key));
        }
        return lol;
    }
}