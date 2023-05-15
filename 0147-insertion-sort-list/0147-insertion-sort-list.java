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
    public ListNode insertionSortList(ListNode head) {

        ListNode nhead=null,ptr=head,tail=nhead;
        
        while(ptr!=null){
            ListNode temp=ptr,x=ptr,pre=temp,xpre=temp;
            
            while(temp!=null){
                if(x.val>temp.val){
                    xpre=pre;
                    x=temp;

                }
                pre=temp;
                temp=temp.next;
                    
            }
            if(x==ptr){
                ptr=x.next;
                x.next=null;

            }
            else{
                xpre.next=x.next;
                x.next=null;
                }

            if(nhead==null){
                        nhead=x;
                        tail=x;
                    }
            else{
                    tail.next=x;
                    tail=x;
                }

        }
        return nhead;
    }
}