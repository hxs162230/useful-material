1195. Fizz Buzz Multithreaded
Medium

146

83

Add to List

Share
Write a program that outputs the string representation of numbers from 1 to n, however:

If the number is divisible by 3, output "fizz".
If the number is divisible by 5, output "buzz".
If the number is divisible by both 3 and 5, output "fizzbuzz".
For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Suppose you are given the following code:

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}
Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
Thread D will call number() which should only output the numbers.



monitor method

!!while和snycronized的搭配運用

class FizzBuzz {
    private int n;
    private int num;
    public FizzBuzz(int n) {
        this.n = n;
        this.num = 1;
    }
    
    
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized(this){
            while(num<=n){
                if(num%3==0&&num%5!=0){
                    num++;
                    printFizz.run();
                    notifyAll();
                }
                else{
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(num<=n){
            if(num%5==0&&num%3!=0){
                num++;
                printBuzz.run();
                notifyAll();
            }
            else{
                wait();
            }
        }    
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(num<=n){
            if(num%15==0){
                num++;
                printFizzBuzz.run();
                notifyAll();
            }
            else{
                wait();
            }
        }    
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(num<=n){
            if(num%3!=0&&num%5!=0){
                printNumber.accept(num);
                num++;
                notifyAll();
            }
            else{
                wait();
            }
        }    
    }
}