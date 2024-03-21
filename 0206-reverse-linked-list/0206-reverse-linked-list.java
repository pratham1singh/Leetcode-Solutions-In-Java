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
    public ListNode reverse(ListNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode ptr=reverse(head.next),temp=ptr;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=head;
        head.next=null;
        return ptr;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}