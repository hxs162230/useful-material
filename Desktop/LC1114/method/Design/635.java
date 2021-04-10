class LogSystem {
    class Pair{
        int id;
        String timestamp;
        public Pair(int id,String timestamp){
            this.id=id;
            this.timestamp=timestamp;
        }
        public int get1(){
            return id;
        }
        public String get2(){
            return timestamp;
        }
    }
    List<Pair> ts = new ArrayList<>();
    String[] unit;
    int[] idx;
    public LogSystem() {
        
        unit = new String[]{"Year","Month","Day","Hour","Minute","Second"};
        idx = new int[]{4,7,10,13,16,19};
    }
    
    public void put(int id, String timestamp) {
        ts.add(new Pair(id,timestamp));
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> lst = new ArrayList<>();
        int i = idx[find(gra,unit)];
        for(Pair p:ts){
            String tmp = p.get2();
            if(tmp.substring(0,i).compareTo(s.substring(0,i))>=0 && tmp.substring(0,i).compareTo(e.substring(0,i))<=0)
                lst.add(p.get1());
        }
        return lst;
    }
    public int find(String gra,String[] unit){
        for(int i=0;i<unit.length;i++){
            if(gra.equals(unit[i])){
                return i;
            }
        }
        return -1;
    }
}
