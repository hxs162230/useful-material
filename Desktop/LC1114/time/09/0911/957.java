class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String,Integer> map = new HashMap<>();
        while(N>0){
            int[] cell = new int[8];
            map.put(Arrays.toString(cells),N--);
            for(int i=1;i<7;i++){
                cell[i]=cells[i-1]==cells[i+1]?1:0;
            }
            if(map.containsKey(Arrays.toString(cell)))
                N%=map.get(Arrays.toString(cell))-N;
            cells=cell;
        }
        return cells;
    }
}