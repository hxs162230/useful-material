445. Add Two Numbers II
Medium

921

122

Favorite

Share
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        
        ListNode cur =new ListNode(0);
        int carry=0;
        while(!s1.isEmpty() ||!s2.isEmpty() ){
            int a=(s1.isEmpty()?0:s1.pop());
            int b=(s2.isEmpty()?0:s2.pop());
            int sum=a+b+carry;
            //System.out.println(sum);
            cur.val=sum%10;
            ListNode nextCur=new ListNode(sum/10);
            nextCur.next=cur;
            cur=nextCur;
            carry=cur.val;
        }
   
        return (cur.val>0?cur:cur.next);
    }
}