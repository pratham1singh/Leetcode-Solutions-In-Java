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
    public ListNode reverse(ListNode head,ListNode pre){
        if(head==null)
            return pre;
        else{
            ListNode forw=head.next;
            head.next=pre;
            return reverse(forw,head);
           
        }
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
}