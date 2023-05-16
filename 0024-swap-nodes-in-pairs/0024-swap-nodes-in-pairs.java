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
    public ListNode swapPairs(ListNode head) {
        
        ListNode ptr=head,forw,temp,pre=head;
        while(ptr!=null&&ptr.next!=null){
            forw=ptr.next.next;
            temp=ptr.next;
            ptr.next.next=ptr;
            ptr.next=null;
            if(pre==head){
               
                head=temp;
                pre=ptr;
            }
            else{
                
                pre.next=temp;
                pre=ptr;
            }
            ptr.next=forw;
            ptr=forw;
            
        }
        return head;
    }
}