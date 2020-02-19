349. Intersection of Two Arrays
Easy

502

919

Favorite

Share
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1=0;
        int idx2=0;
        List<Integer> arr=new ArrayList<Integer>();        
        while(idx1<nums1.length && idx2<nums2.length){
            if(nums1[idx1]>nums2[idx2]) idx2++;
            else if (nums1[idx1]<nums2[idx2]) idx1++;
            else{
                if(arr.isEmpty() || arr.get(arr.size()-1)!=nums1[idx1])
                arr.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
 
            
        }
        int[] numbers = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
                numbers[i] = arr.get(i);
        }
        return numbers;
    }
}