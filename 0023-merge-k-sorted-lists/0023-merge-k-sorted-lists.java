/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insert(ListNode head, ListNode val) {
        if(head == null) {
            val.next = null;
            return val;
        }

        ListNode pre = null, ptr = head;
        while(ptr!=null && ptr.val<val.val) {
            pre = ptr;
            ptr = ptr.next;
        }
        if(pre == null) {
            val.next = head;
            head = val;
        }
        else {
            val.next = pre.next;
            pre.next = val;
        }
       
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for(ListNode list: lists) {
            while(list!=null) {
                ListNode x= list;
                list = list.next;
                head = insert(head, x);
                
            }
        }
        return head;
    }
}