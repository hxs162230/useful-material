234. Palindrome Linked List
Easy

2058

293

Favorite

Share
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        if(head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        
        slow = reverselst(slow);
        ListNode tst = slow;
        
        
        ListNode cur = head;
        while(cur!=null&&slow!=null){
            if(cur.val!=slow.val) return false;
            cur=cur.next;
            slow=slow.next;
        }
        return true;

    }
    public ListNode reverselst(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }