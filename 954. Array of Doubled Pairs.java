954. Array of Doubled Pairs
Medium

865

102

Add to List

Share
Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: arr = [1,2,4,16,8,4]
Output: false
 

Constraints:

2 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        //0 1
        //1 3
        //2 5
        Map<Integer,Integer> map = new TreeMap<>();
        int len = arr.length;
        for(int i=0;i<len;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int want = 0;
        for(Integer key:map.keySet()){
            if(map.get(key)==0) continue;
            //from left to right ex: key:-2 want:-1  || key:2 want:4
            want = key>=0 ? key*2 : key/2;
            if(key<0 && key%2!=0) return false;
            if(map.get(key)>map.getOrDefault(want,0)) return false;
            map.put(want,map.get(want)-map.getOrDefault(key,0));
        }
        return true;
    }
}