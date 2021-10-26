752. Open the Lock
Medium

872

43

Add to List

Share
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.



class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        HashSet<String> dead = new HashSet<>();
        for(String d:deadends) dead.add(d);
        if(dead.contains("0000")) return -1;
        char[][] dirs = {{'9','1'},{'0','2'},{'1','3'},{'2','4'},{'3','5'},{'4','6'},{'5','7'},{'6','8'},{'7','9'},{'8','0'}};
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        HashSet<String> seen = new HashSet<>();
        seen.add("0000");
        int step = 0;
        while(!q1.isEmpty()&&!q2.isEmpty()){
            if(q1.size()>q2.size()){
                HashSet<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            HashSet<String> nextSet = new HashSet<>();
            for(String curCode: q1){
                char[] curCodeArr = curCode.toCharArray();
                for(int i=0;i<curCodeArr.length;i++){
                    char old = curCodeArr[i];
                    int idx = old-'0';
                    for(char c:dirs[idx]){
                        curCodeArr[i] = c;
                        String nextCode = String.valueOf(curCodeArr);
                        if(q2.contains(nextCode)) return step+1;
                        if(dead.contains(nextCode)) continue;
                        if(seen.contains(nextCode)) continue;
                        seen.add(nextCode);
                        nextSet.add(nextCode);
                    }
                    curCodeArr[i] = old;
                }
            }
            q1 = nextSet;
            step++;
        }
        return -1;
    }
}