class Solution {
    public List<String> fizzBuzz(int n) {
        int cnt=0;
        int fizz=3;
        int buzz=5;
        List<String> lst = new ArrayList<>();
        while(++cnt<=n){
            if(cnt==fizz&&cnt==buzz){
                fizz+=3;
                buzz+=5;
                lst.add("FizzBuzz");
            }
            else if(cnt==fizz){
                fizz+=3;
                lst.add("Fizz");
            }
            else if(cnt==buzz){
                buzz+=5;
                lst.add("Buzz");
            }
            else 
                lst.add(String.valueOf(cnt));
        }
        return lst;
    }
}