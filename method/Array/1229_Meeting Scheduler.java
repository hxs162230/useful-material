1229. Meeting Scheduler
Medium

108

7

Add to List

Share
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.  

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 10^4
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 10^9
1 <= duration <= 10^6 


class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a,b)->(a[0]-b[0]));
        Arrays.sort(slots2,(a,b)->(a[0]-b[0]));
        List<Integer> mlst = find(slots1,slots2,duration);
        //List<Integer> res = new ArrayList<>();
        //for(List<Integer> l:mlst) System.out.println(l.get(0)+"---"+l.get(1));
        // for(List<Integer> l:mlst){
        //     if(l.get(1)-l.get(0)>=duration){
        //         res.add(l.get(0));
        //         res.add(l.get(0)+duration);
        //         break;
        //     }
        // }
        return mlst;
    }
    public List<Integer> find(int[][] s1,int[][] s2,int d){
        int i = 0;
        int j = 0;
        while(i<s1.length&&j<s2.length){
            if(s1[i][0]>s2[j][1]){
                j++;
            }
            else if(s1[i][1]<s2[j][0]){
                i++;
            }
            else{
                int st = Math.max(s1[i][0],s2[j][0]);
                int ed = Math.min(s1[i][1],s2[j][1]);
                if(ed-st>=d){
                    return Arrays.asList(st,st+d);
                }
                if(s1[i][1]>s2[j][1]) j++;
                else i++;
            }
        }
        return Arrays.asList();
        
    }
}