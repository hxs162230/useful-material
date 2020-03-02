143. Reorder List
Medium

1173

86

Favorite

Share
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
T:O(1)

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null ||head.next.next==null) return;
        ListNode slow =head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode midPoint =slow.next;
        slow.next=null;
        ListNode pre=null;
        ListNode cur=midPoint;
        
        
        while(cur!=null){
        ListNode next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
      
        }
        //pre=head2;
        //System.out.println(pre.next.val);
        cur=head;
        while(cur!=null && pre!=null){
        ListNode tmp=cur.next;
        cur.next=pre;
        ListNode tmp2=pre.next;
        pre.next=tmp;
        pre=tmp2;
        cur=tmp;
        }
        
        
    }
}