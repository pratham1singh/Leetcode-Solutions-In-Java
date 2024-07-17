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
    
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode ptr=head,pre=null,forw=head.next;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int x:nums)
            map.put(x,true);

        while(ptr!=null){
            if(map.get(ptr.val)!=null){
                if(pre==null){
                    head=ptr.next;
                    ptr.next=null;
                    ptr=forw;

                    if(forw!=null)
                        forw=forw.next;
                    else forw=null;
                }
                else {
                    pre.next=forw;
                    ptr=forw;
                    if(forw!=null)
                        forw=forw.next;
                    else forw=null;
                }
            }
            else{
                pre=ptr;
                ptr=ptr.next;
                if(forw!=null)
                    forw=forw.next;
                else forw=null;
            }
        }
        return head;
    }
}