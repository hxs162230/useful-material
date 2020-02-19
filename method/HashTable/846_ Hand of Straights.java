846. Hand of Straights

Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
 

Note:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W !=0) return false;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            if(!tm.containsKey(hand[i]))
                tm.put(hand[i],0);
                tm.put(hand[i],tm.get(hand[i])+1);
            
        }
        //System.out.println(tm.firstKey());
        while(!tm.isEmpty()){
            int first = tm.firstKey();
            for(int i=0;i<W;i++){
                if(!tm.containsKey(first+i)) return false;
                tm.put(first+i,tm.get(first+i)-1);
                if(tm.get(first+i)==0) tm.remove(first+i);
                
            }
        }
        return true;
    }
}