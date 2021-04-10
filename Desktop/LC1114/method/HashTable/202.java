class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        while(n!=1){
        
        while(n>0){
            
            sum+=(n%10)*(n%10);
            n/=10;
            //System.out.println("n"+n);
        }
        if(sum==1) return true;
        if(set.contains(sum)) return false;
        set.add(sum);
        
        n=sum;
        sum=0;
        }
       return true;

    }
}