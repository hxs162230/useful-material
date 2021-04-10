160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int lenA=1,lenB=1;
        ListNode curA=headA;
        while(curA.next!=null){
            curA=curA.next;
            lenA++;
        }
        ListNode curB =headB;
        while(curB.next!=null){
            curB=curB.next;
            lenB++;
        }
        int diff=lenA-lenB;
        if(diff>0){
            while(diff>0){
                headA=headA.next;
                diff--;
            }
        }
        else{
            while(diff<0){
                headB=headB.next;
                diff++;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB) break;
            headA=headA.next;
            headB=headB.next;
        }
        return (headA!=null&&headB!=null?headA:null);
    }
}
sol2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(cur1!=null){
            cur1 = cur1.next;
            len1++;
        }
        while(cur2!=null){
            cur2 = cur2.next;
            len2++;
        }
        cur1 = headA;
        cur2 = headB;
        int diff = Math.abs(len1-len2);
        if(diff>0){
            if(len1>len2){
                while(diff-->0) cur1 = cur1.next;
            }
            else{
                while(diff-->0) cur2 = cur2.next;
            }
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1!=null?cur1:null;
    }
}
这道题还有一种特别巧妙的方法，虽然题目中强调了链表中不存在环，但是我们可以用环的思想来做，
我们让两条链表分别从各自的开头开始往后遍历，
当其中一条遍历到末尾时，我们跳到另一个条链表的开头继续遍历。
两个指针最终会相等，而且只有两种情况，一种情况是在交点处相遇，
另一种情况是在各自的末尾的空节点处相等。为什么一定会相等呢，
因为两个指针走过的路程相同，是两个链表的长度之和，所以一定会相等。
这个思路真的很巧妙，而且更重要的是代码写起来特别的简洁，参见代码如下：

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1!=cur2){
            cur1 = cur1==null? headB:cur1.next;
            cur2 = cur2==null? headA:cur2.next;
        }
        return cur1;
    }
}