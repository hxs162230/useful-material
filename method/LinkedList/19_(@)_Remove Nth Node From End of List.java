19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(n-->0){
            if(cur==null) return head.next;    
            cur=cur.next;
        }
        while(cur!=null){
            //System.out.println("@");
            pre=pre.next;
            cur=cur.next;
        }
        pre.next=pre.next.next;
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dmy = new ListNode(-1);
        dmy.next=head;
        ListNode cur = dmy;
        while(n-->0){
            if(cur==null) return head.next;
            cur=cur.next;
        }
        ListNode pre = dmy;
        ListNode x = null;
        while(cur!=null){
            x=pre;
            cur=cur.next;
            pre=pre.next;
        }
        x.next = pre.next;
        return dmy.next;
    }
}