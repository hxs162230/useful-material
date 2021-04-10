109. Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
这道题是要求把有序链表转为二叉搜索树，
和之前那道 Convert Sorted Array to Binary Search Tree 思路完全一样，
只不过是操作的数据类型有所差别，一个是数组，一个是链表。
数组方便就方便在可以通过index直接访问任意一个元素，而链表不行。
由于二分查找法每次需要找到中点，而链表的查找中间点可以通过快慢指针来操作，
可参见之前的两篇博客 Reorder List 和 Linked List Cycle II 有关快慢指针的应用。
找到中点后，要以中点的值建立一个数的根节点，然后需要把原链表断开，分为前后两个链表，
都不能包含原中节点，然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可。代码如下：

T:O(NlogN)

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null ) return null;
        if(head.next==null ) return new TreeNode(head.val);
        ListNode fast=head,slow=head;
        ListNode pre = slow;
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        pre.next=null;
        TreeNode root = new TreeNode(slow.val);
        if(head!=slow)
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);
        
        return root
    }
}