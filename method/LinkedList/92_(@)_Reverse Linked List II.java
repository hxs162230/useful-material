92. Reverse Linked List II
Medium

1544

107

Favorite

Share
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==m || n<=0 ||m<=0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        ListNode firstpre,first;
        ListNode pre,next;
       for(int i=1;i<=m-1;i++){
           cur=cur.next;
       }
        pre = cur;
        firstpre = cur;
        cur = cur.next;
        first = cur;

        for(int i=m;i<=n;i++){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        firstpre.next = pre;
        first.next = cur;
        return dummy.next;
        
    }
}
        
        