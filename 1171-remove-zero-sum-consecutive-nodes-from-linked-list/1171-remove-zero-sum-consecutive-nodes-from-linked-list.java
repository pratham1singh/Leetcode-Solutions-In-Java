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
    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode ptr=head;
        st.push(new ListNode(0));
        map.put(0,st.peek());
        int c=0;

        while(ptr!=null){
            c+=ptr.val;
            if(map.get(c)!=null){
                int k=c;
                c-=ptr.val;
                while(st.peek()!=map.get(k)){
                    map.remove(c);
                    c-=st.peek().val;
                    st.pop();
                }
                ptr=ptr.next;
            }
            else{
                st.push(ptr);
                map.put(c,ptr);
                ptr=ptr.next;
            }
            // System.out.println(st);
        }
        while(st.size()>0)
            st2.push(st.pop());
        st2.pop();
        
        ListNode nhead= new ListNode(-1);
        ptr=nhead;
        while(st2.size()>0){
            ptr.next=st2.peek();
            st2.peek().next=null;
            st2.pop();
            ptr=ptr.next;
        }
        return nhead.next;


    }
}