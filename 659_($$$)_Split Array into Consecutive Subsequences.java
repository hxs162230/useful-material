659. Split Array into Consecutive Subsequences
Medium

1104

385

Add to List

Share
Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False
 

Constraints:

1 <= nums.length <= 10000

/*
The idea is , we scan the array for two times.
In first pass we count the frequencies of all numbers and record them in cnt
For the second pass, we are "building" our subsequences by the following rules:

We use a hashmap called tails to record extra information, where tails[i] means the number of consecutive subsequences we've found so far, who are longer than 3 , and tailed by number i,
When we meet number i, try to put it to the tail of one of found subsequences tailed by i-1. No need to worry that we might have a better choice to consider i as a brand new head for another subsequence, because we can always append the new subsequence to a previous one tailed by i-1.
If we can't, it will cost one i+1 and one i+2 later to generate a new sequence. We just pay that right now by decrease cnt[i+1] and cnt[i+2]. Some one may worry that we make use of the numbers we haven't scanned so far. But actually we've already kept track of the numbers remained by cnt. Just imaging we grab the numbers needed from the very end of the string, and mark them as "used". If there is no such number available to pay, cnt will tell us by checking cnt[i+1] cnt[i+2] is positive or not
The code is short and concise, shown below:
*/
O(N) for time
O(N) for space

greedy algo
We iterate through the array once to get the frequency of all the elements in the array
We iterate through the array once more and for each element we either see 

if it can be appended to a previously constructed consecutive sequence or 
if it can be the start of a new consecutive sequence. 
If neither are true, then we return false.


class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer,Integer> tail = new HashMap<>();
        for(int i:nums){
            if(map.get(i)==0) continue;
            
            map.put(i,map.get(i)-1);
            
            //先找tail=i-1 的seq
            if(tail.getOrDefault(i-1,0)>0){
                tail.put(i-1,tail.get(i-1)-1);
                tail.put(i,tail.getOrDefault(i,0)+1);
            }   
            //找不到tail=i-1 
            //另起一個新的seq ; tail=i+2
            else if(map.getOrDefault(i+1,0)>0&&map.getOrDefault(i+2,0)>0){
                map.put(i+1,map.get(i+1)-1);
                map.put(i+2,map.get(i+2)-1);
                tail.put(i+2,tail.getOrDefault(i+2,0)+1);
            }
            else return false;
            
        }
        return true;
    }
}