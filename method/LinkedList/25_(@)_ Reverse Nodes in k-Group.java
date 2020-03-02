25. Reverse Nodes in k-Group
Hard

1728

337

Add to List

Share
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dmy = new ListNode(-1);
        dmy.next=head;
        ListNode pre = dmy;
        ListNode cur = head;
        int idx=0;
        while(cur!=null){
            idx++;
            if(idx%k==0){
                pre = reverseOne(pre,cur.next);
                cur=pre.next;
            }
            else{
            cur=cur.next;
            
            }
        }
        return dmy.next;
	}
    public ListNode reverseOne(ListNode first,ListNode last){
        ListNode previous=first;
        ListNode node=first.next;
        ListNode current=first.next;
        while(current!=last){
            ListNode next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        first.next=previous;
        node.next=current;
        return node;
    }
}