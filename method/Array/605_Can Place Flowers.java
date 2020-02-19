605. Can Place Flowers

Suppose you have a long flowerbed in which some of the plots are planted and some are not.

However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, 

return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.


10001 =>1
00001 =>2  0-00001     
00000 =>3  0-00000-0
10000 =>2    10000-0

//前面補0可以讓第一個0開始種

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum=0;
        int cnt=0;
        List<Integer> lst = new ArrayList<>();
        for(int i:flowerbed) lst.add(i);
        if(lst.get(0)==0) lst.add(0,0);
        if(lst.get(lst.size()-1)==0) lst.add(0);
        
        for(int i=0;i<=lst.size();i++){
            //System.out.print(lst.get(i));
            if(i<lst.size()&&lst.get(i)==0){ 
                cnt++;
            }
            else{
                //System.out.print(cnt);
                sum+=(cnt-1)/2;
                cnt=0;
            }
        }
        //System.out.print(sum);
        return sum>=n;
    }
}