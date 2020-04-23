354. Russian Doll Envelopes
Hard

939

35

Add to List

Share
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).



class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //LIS
        //why sort h reverse order when width tie ?
        //3,3   3,4   ==>   3,4   3,3   LIS==1   (not 2)
        //(3,3) cannot fit into (3,4),in this case we return 1;
        int m = envelopes.length;
        if(m==0) return 0;
        int n = envelopes[0].length;
        Arrays.sort(envelopes,(a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        int res = 0;
        int[] dp = new int[m+1];
        for(int i=1;i<=m;i++) dp[i] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<i;j++){
                if(envelopes[j-1][1]<envelopes[i-1][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //LIS
        //why sort h reverse order when width tie ?
        //3,3   3,4   ==>   3,4   3,3   LIS==1   (not 2)
        //(3,3) cannot fit into (3,4),in this case we return 1;
        int m = envelopes.length;
        if(m==0) return 0;
        int n = envelopes[0].length;
        Arrays.sort(envelopes,(a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        List<Integer> lst = new ArrayList<>();
        for(int[] en:envelopes){
            int left = 0;
            int right = lst.size();
            while(left<right){
                int mid = left+(right-left)/2;
                if(lst.get(mid)>=en[1]){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }
            if(right>=lst.size()){
                lst.add(en[1]);
            }
            else{
                lst.set(right,en[1]);
            }
        }
        return lst.size();
    }
}