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