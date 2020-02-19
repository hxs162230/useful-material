86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessThan = new ListNode(-1);
        ListNode dmy =new ListNode(-1);
        dmy.next = head;
        ListNode cur = dmy;
        ListNode lt = lessThan;
        while(cur.next!=null){
            if(cur.next.val<x){
                lt.next = cur.next;
                cur.next = cur.next.next;
                lt = lt.next;
                lt.next = null;
            }
            else{
                cur = cur.next;
            }
        }
        lt.next = dmy.next;
        return lessThan.next;
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
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(-1);
        ListNode dmy1 = lt;
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode pre = dmy;
        ListNode cur = head;
        while(cur!=null){
        ListNode next = cur.next;
            if(cur.val<x){
                cur.next=null;
                pre.next = next;
                lt.next = cur;
                lt=lt.next;
                cur=next;
            }
            else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        lt.next = dmy.next;
        return dmy1.next;
    }
}