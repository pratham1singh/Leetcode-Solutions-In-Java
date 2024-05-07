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
    public int doubleList(ListNode head){
        if(head==null)
            return 0;
        else{
            int c=doubleList(head.next),num=2*head.val+c;
            head.val=num%10;
            return num/10;
        }
    }
    public ListNode doubleIt(ListNode head) {
        int c=doubleList(head);
        if(c!=0){
            ListNode nhead = new ListNode(c);
            nhead.next=head;
            return nhead;
        }
        return head;
    }
}