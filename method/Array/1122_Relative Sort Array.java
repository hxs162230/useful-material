1122. Relative Sort Array
Easy

521

38

Add to List

Share
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
 

Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.



class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr2.length;i++) map.put(arr2[i],i);
        Integer[] Arr1 = Arrays.stream(arr1).boxed().toArray(Integer[] :: new);
        Arrays.sort(Arr1,(a,b)->map.getOrDefault(a,1000+a).compareTo(map.getOrDefault(b,1000+b)));
        for(int i=0;i<arr1.length;i++) arr1[i] = Arr1[i];
        return arr1;
    }

}


buckets sort 
O(1)
O(1)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] buckets = new int[1001];
        for(int i:arr1) buckets[i]++;
        int idx = 0;
        for(int i:arr2){
            while(buckets[i]-->0){
                arr1[idx++] = i;
            }
        }
        for(int i=0;i<buckets.length;i++){
            while(buckets[i]-->0){
                arr1[idx++] = i;
            }
        }
        return arr1;
    }
}