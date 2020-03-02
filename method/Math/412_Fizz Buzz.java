412. Fizz Buzz
Easy

717

1020

Add to List

Share
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

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