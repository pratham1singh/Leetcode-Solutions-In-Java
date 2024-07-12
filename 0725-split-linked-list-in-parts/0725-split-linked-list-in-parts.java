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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n=0;
        ListNode ptr= head,ans[];
        while(ptr!=null){
            n++;
            ptr=ptr.next;
        }
        int l=n/k,count=n%k,j=0;
        ans= new ListNode[k];
        ptr=head;
        if(n<k){
            l=1;
            count=0;
        }
        while(ptr!=null){
            int t=1;
            ListNode temp=ptr,forw;
            while(t<l){
                t++;
                ptr=ptr.next;
            }
            if(count>0){
                count--;
                ptr=ptr.next;
            }
            forw=ptr.next;
            ptr.next=null;
            ans[j++]=temp;
            ptr=forw;
        }
        return ans;
    }
}