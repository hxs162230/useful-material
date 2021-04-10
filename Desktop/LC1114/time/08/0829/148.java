/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
T:O(NlogN)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null ||head.next==null) return head;
        
        ListNode slow=head,fast=head;
        ListNode pre=head;
        
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        
        return mergeTwoLists(sortList(head),sortList(slow));
        
        
    }
    public ListNode mergeTwoLists(ListNode head1,ListNode head2){
        
        ListNode dummy = new ListNode(-1);
        ListNode cur=dummy;
        while(head1!=null && head2!=null){
            if(head1.val>head2.val){
                cur.next= new ListNode(head2.val);
                head2=head2.next;
                cur=cur.next;
            }
            else{
                cur.next=new ListNode(head1.val);
                head1=head1.next;
                cur=cur.next;
            }
            
        }
        while(head1!=null){
            cur.next=new ListNode(head1.val);
            cur=cur.next;
            head1=head1.next;
        }
        while(head2!=null){
            cur.next=new ListNode(head2.val);
            cur=cur.next;
            head2=head2.next;
        }
        
        return dummy.next;
        
        
    }
}