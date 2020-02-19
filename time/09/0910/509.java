class Solution {
    public int fib(int N) {
        if(N<=0)return 0;
        if(N==1)return 1;
        int a=0;
        int b=1;
        int tmp=0;
        for(int i=2;i<N+1;i++){
            tmp=b;
            b=a+b;
            a=tmp;
        }
        return b;
    }
}