299. Bulls and Cows

You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.


我们其实可以用一次循环就搞定的，在处理不是bulls的位置时，我们看如果secret当前位置数字的映射值小于0，
则表示其在guess中出现过，cows自增1，然后映射值加1，如果guess当前位置的数字的映射值大于0，
则表示其在secret中出现过，cows自增1，然后映射值减1，参见代码如下：

class Solution {
    public String getHint(String secret, String guess) {
        int bullcnt=0;
        int cowcnt=0;
        int[] num = new int[10];
        for(int i=0;i<secret.length();i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1==c2) bullcnt++;
            else{
                if(num[c1-'0']++<0) cowcnt++;
                if(num[c2-'0']-->0) cowcnt++;
            }
        }
        return String.valueOf(bullcnt)+"A"+String.valueOf(cowcnt)+"B";
    }
}