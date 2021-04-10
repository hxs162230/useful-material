class Solution {
    public int maxPoints(int[][] points) {
        /*
        遍历每个点，看它和后面的每个点构成的直线上有多少个点
        对每个点建立map，斜率是key
        斜率要用分数的形式，不要用double的形式存
        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
        重合的点特殊处理
    	*/
        //if(points.length<=0) return 0;
    	if(points.length<=2) return points.length;

        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        int res=0;
        for(int i=0;i<points.length;i++){
        	map.clear();
        	int overlap=0;
        	int maxInthisLine=0;
        	for(int j=i+1;j<points.length;j++){
        		int delta_x = points[j][0] - points[i][0];
        		int delta_y = points[j][1] - points[i][1];
        		if(delta_y==0 && delta_x==0){
        			overlap++;
        			continue;
        		}
        		int gcd = generateGCD(delta_x,delta_y);
        		if(gcd!=0){
        			delta_x/=gcd;
        			delta_y/=gcd;
        		}
        		if(map.containsKey(delta_x)){
        			if(map.get(delta_x).containsKey(delta_y)){
        				map.get(delta_x).put(delta_y,map.get(delta_x).get(delta_y)+1);
        			}
        			else{
        				map.get(delta_x).put(delta_y,1);
        			}
        		}
        		else{
        			HashMap<Integer,Integer> m = new HashMap<>();
        			map.put(delta_x,m);
        			map.get(delta_x).put(delta_y,1);
        		}
        		maxInthisLine = Math.max(maxInthisLine,map.get(delta_x).get(delta_y)); 
        	}
        	res = Math.max(res,maxInthisLine+overlap+1);
        }
        return res;
    }
    public int generateGCD(int a,int b){
    	if(b==0) return a;
    	return generateGCD(b,a%b);
    }
}