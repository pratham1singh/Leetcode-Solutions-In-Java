/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node >map = new HashMap<>();
        if(head==null)
        return null;
        Node head2=null,ptr=head,last=head;
        while(ptr!=null)
        {
            Node temp=new Node(ptr.val);
            map.put(ptr,temp);
            if(head2==null)
            {
                head2=temp;
                last=temp;
            }
            else{
                last.next=temp;
                last=temp;
            }
            ptr=ptr.next;

        }
        ptr=head;
        Node ptr2=head2;
        while(ptr!=null)
        {
            if(ptr.random==null)
            {
                ptr2.random=null;
            }
            else{
                ptr2.random= map.get(ptr.random);
            }
            ptr=ptr.next;
            ptr2=ptr2.next;
        }
       return head2; 
    }
    
}