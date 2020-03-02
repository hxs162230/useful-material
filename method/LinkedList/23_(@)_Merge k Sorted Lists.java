23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

T:O(Nlongk) k=num of listNode in lists , n = num of nodes
S:O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int n = lists.length;
        
        while(n>1){
            int m =(n+1)/2;
            for(int i=0;i<n/2;i++){
                lists[i] = mergeTwo(lists[i],lists[i+m]);
            }
            n=m;
        }
        return lists[0];
    }
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode dmy = new ListNode(-1);
        ListNode cur = dmy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next = new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                cur.next = new ListNode(l2.val);
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next = l1==null?l2:l1;
        return dmy.next;
    }
}