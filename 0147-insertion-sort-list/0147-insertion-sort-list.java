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
    ListNode head;
    public ListNode get_min(){
        ListNode mn=head,ptr=head,pre_mn=null,pre_ptr=null;

        while(ptr!=null){
            if(mn.val>ptr.val){
                mn=ptr;
                pre_mn=pre_ptr;
                
            }
            pre_ptr=ptr;
            ptr=ptr.next;
        }
System.out.println(head.val+" "+mn.val);
        if(pre_mn!=null){
            pre_mn.next=mn.next;
            mn.next=null;
        }
        else{
            head=mn.next;
        }
        
        return mn;
        
    }
    public ListNode insertionSortList(ListNode head) {
        this.head=head;
        
        ListNode new_head=new ListNode(),ptr=new_head,tail=new_head;
        while(this.head!=null){
            ListNode mn=get_min();
            tail.next=mn;
            tail=mn;
        }
        return new_head.next;

    }
}