/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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