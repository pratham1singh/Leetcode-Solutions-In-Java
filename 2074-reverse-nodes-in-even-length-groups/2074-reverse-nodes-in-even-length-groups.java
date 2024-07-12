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
        if(head.next==null)
            return head;
        else{
            ListNode temp=head,temp2,ptr;
            head=head.next;
            temp.next=null;
            temp2=reverse(head);
            ptr=temp2;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=temp;
            return temp2;
        }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int l=1;
        ListNode ptr=head,ans=new ListNode(-1),temp=ans;

        while(ptr!=null){
            int k=l,n=1;
            ListNode a=ptr,b;
            while(ptr.next!=null&&k>1){
                ptr=ptr.next;
                k--;
                n++;
            }
            b=ptr;
            ptr=ptr.next;
            b.next=null;
            if(n%2==0){
                ListNode x=reverse(a);
                temp.next=x;
                temp=a;  
            }
            else{
                temp.next=a;
                temp=b;
            }
            l++;
        }
        return ans.next;
    }
}