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
    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null)
            return list2;
         if(list2==null)
            return list1;
        

        else if(list1.val<=list2.val){
            ListNode x= new ListNode(list1.val);
            x.next=merge(list1.next,list2);
            return x;
        }
        else{
             ListNode x= new ListNode(list2.val);
            x.next=merge(list1,list2.next);
            return x;
        }
    }
    public ListNode get_mid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode x=slow.next;
        slow.next=null;
        //it is returning head of second list
        return x;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        else{
            ListNode list1=head;
            ListNode list2=get_mid(head);
            ListNode l1=sortList(list1);
            ListNode l2=sortList(list2);
            System.out.println(l1.val+" "+l2.val);
            return merge(l1,l2);
        }
        
    }
}