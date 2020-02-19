539. Minimum Time Difference
Medium

309

104

Favorite

Share
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.


T:O(N) N = num of chars

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] slot = new boolean[24*60];
        for(String timePoint:timePoints){
            String[] time = timePoint.split("\\:");
            int hr = Integer.parseInt(time[0]);
            int sec = Integer.parseInt(time[1]);
            int i=hr*60+sec;
            if(slot[i]) return 0;
            slot[i]=true;
        }
        int min=Integer.MAX_VALUE;
        int pre=Integer.MAX_VALUE;
        int first=Integer.MAX_VALUE;
        int last=Integer.MIN_VALUE;
        for(int i=0;i<60*24;i++){
            if(slot[i]){
                if(pre!=Integer.MAX_VALUE)
                    min=Math.min(min,i-pre);
                pre=i;
                last=Math.max(last,i);
                first=Math.min(first,i);
            }
        }
        //System.out.print(first+" "+last);
        return Math.min(min,60*24-last+first);
    }
}