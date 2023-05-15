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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tail=head,ptr=head;
        int n=0;
        while(tail!=null){
            n+=1;
            if(n==k)
                ptr=tail;
             
            tail=tail.next;
            
            
        }
        n=n-k+1;
        tail=head;
        while(n>1){
            n-=1;
            tail=tail.next;
        }
        System.out.println(tail.val+" "+ptr.val);
        n=tail.val;
        tail.val=ptr.val;
        ptr.val=n;
        return head;
        

    }
}