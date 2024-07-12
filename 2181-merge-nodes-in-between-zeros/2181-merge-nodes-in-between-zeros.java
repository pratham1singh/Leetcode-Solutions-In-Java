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
    public ListNode mergeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode x=head;
        head=head.next;
        x.next=null;
        st.push(x);

        while(head!=null){
            if(head.val==0){
                int s=0;
                while(st.peek().val!=0)
                    s+=st.pop().val;
                st.pop();
                st.push(new ListNode(s));
                st.push(head);
            }
            else
                st.push(new ListNode(head.val));
            head=head.next;
            
        }

        st.pop();
        head=st.pop();

        while(st.size()>0){
            ListNode temp=st.pop();
            temp.next=head;
            head=temp;
        }
        return head;
    }
}