458. Poor Pigs

There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?

Answer this question, and write an algorithm for the general case.

 

General case:

If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.

 

Note:

A pig can be allowed to drink simultaneously on as many buckets as one would like, and the feeding takes no time.
After a pig has instantly finished drinking buckets, there has to be a cool down time of m minutes. During this time, only observation is allowed and no feedings at all.
Any given bucket can be sampled an infinite number of times (by an unlimited number of pigs).


2. What if we could have more than one attempts?

Eg. 4 buckets, 15 mins to die, and 30 mins to test.

At the moment, I consider the problem as an encoding problem: With more attempts, how to use fewer pigs to represent all the buckets?

I got lost at this step by keep thinking the binary way. After hanging around the forum, I got the idea to change my views. Let's go back to the one shot situation. What does the binary form mean? It's much easier if we regard it as:

0 means the pig does not drink and die.
1 means the pig drinks in the first (and only) round.
We could generalise with:

0 means the pig does not drink and die.
1 means the pig drinks in the first round and die.
2 means the pig drinks in the second round and die.
...
t means the pig drinks in the t-th round and die.
Conclusion: If we have t attempts, we could use t+1-based number to represent (encode) the buckets. (That's also why the first conclusion uses the 2-based number)

Example
Eg. 8 buckets, 15 mins to die, and 40 mins to test.

We have 2 (= (40/15).floor) attempts, as a result we'll use 3-based number to encode the buckets.

How many pigs do we need? Answer is 2 (= Math.log(8, 3).ceil)

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        double numOfAttempt = Math.floor(minutesToTest/minutesToDie);
        return (int)Math.ceil(Math.log(buckets)/Math.log(numOfAttempt+1));
    }
}