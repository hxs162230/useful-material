399. Evaluate Division

Equations are given in the format A / B = k, 

where A and B are variables represented as strings, and k is a real number 

(floating point number). Given some queries, return the answers. 

If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , 

where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        HashSet<String> seen = new HashSet<>();
        int i=0;
        for(List<String> eq:equations){
            String a = eq.get(0);
            String b = eq.get(1);
            map.putIfAbsent(a,new HashMap<>());
            map.putIfAbsent(b,new HashMap<>());
            map.get(a).put(b,values[i]);
            map.get(b).put(a,1/values[i++]);
        }
        i=0;
        double[] res = new double[queries.size()];
        for(List<String> qr:queries){
            String a = qr.get(0);
            String b = qr.get(1);
            res[i++]=dfs(a,b,new HashSet<>(),map);   <===HashSet此處要RESET
        }
        return res;
    }
    public double dfs(String st,String ed,HashSet<String> seen,HashMap<String,HashMap<String,Double>> map){
        if(!map.containsKey(st)) return -1.0;
        if(st.equals(ed)) return 1.0;
        seen.add(st);
        for(String next:map.get(st).keySet()){
            if(seen.contains(next)) continue; //避免DEAD LOOP
            //seen.add(next);
            double accumulator = dfs(next,ed,seen,map);
            if(accumulator>0) return accumulator*map.get(st).get(next);
        }
        return -1.0;
    }
}