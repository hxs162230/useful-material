914. X of a Kind in a Deck of Cards
Easy

514

127

Add to List

Share
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].
Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2].
 

Constraints:

1 <= deck.length <= 10^4
0 <= deck[i] < 10^4

O(N) time;
O(1) space;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] number = new int[10000];
        for(int i:deck){
            number[i]++;
        }
        int k = 0;
        for(int i:number){
            if(i==0) continue;
            k = gcd(i,k);
        }
        if(k>=2) return true;
        else return false;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}