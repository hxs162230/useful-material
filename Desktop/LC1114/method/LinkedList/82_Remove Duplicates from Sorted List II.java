82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode pre =dummy;
        dummy.next=head;
       
        while(pre.next!=null){
            ListNode cur =pre.next;
            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(cur!=pre.next) pre.next=cur.next;
            else pre=pre.next;
            
        }
        return dummy.next;
    }
}