61. Rotate List

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

这道题还有一种解法，跟上面的方法类似，但是不用快慢指针，一个指针就够了，
原理是先遍历整个链表获得链表长度n，然后此时把链表头和尾链接起来，
在往后走n - k % n个节点就到达新链表的头结点前一个点，这时断开链表即可，代码如下:

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode cur = head;
        int len = 1;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur.next=head;
        int shift = len-k%len;
        for(int i=1;i<=shift;i++) cur=cur.next;
        ListNode next = cur.next;
        cur.next=null;
        return next;
            
    }
}