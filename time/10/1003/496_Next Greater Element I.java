496. Next Greater Element I

You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are 

subset of nums2. 

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 

If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> nextBig = new HashMap<>();
        //存一個遞減STK
        for(int i:nums2){
            while(!stk.isEmpty()&&stk.peek()<i){
                nextBig.put(stk.peek(),i);
                stk.pop();
            }
            stk.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            if(nextBig.containsKey(nums1[i])) nums1[i] = nextBig.get(nums1[i]);
            else nums1[i]=-1;
        }
        return nums1;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nge = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(!stk.isEmpty()&&stk.peek()<nums2[i]){
                nge.put(stk.peek(),nums2[i]);
                stk.pop();
            }
            stk.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = (nge.containsKey(nums1[i])?nge.get(nums1[i]):-1);
        }
        return nums1;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i:nums2){
            while(!stk.isEmpty()&&stk.peek()<i){
                int t = stk.pop();
                map.put(t,i);
            }
            stk.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            res[i] = (map.containsKey(nums1[i])?map.get(nums1[i]):-1);
        }
        return res;
    }
}