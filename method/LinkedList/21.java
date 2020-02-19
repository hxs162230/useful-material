21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

T:O(M+N)
S:O(M+N)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dmy = new ListNode(-1);
        ListNode cur = dmy;
        
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1==null)?l2:l1;
        return dmy.next;
    }
}