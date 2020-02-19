203. Remove Linked List Elements


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode cur = head;
        ListNode pre = dmy;
        while(cur!=null){
           if(cur.val==val){
               pre.next = cur.next;
               cur = pre.next;
           }
           else{
               pre = pre.next;
               cur = cur.next;
           }    
        }
        return dmy.next;
    }
}