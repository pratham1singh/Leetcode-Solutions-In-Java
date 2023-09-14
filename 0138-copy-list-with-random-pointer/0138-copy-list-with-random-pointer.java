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
    public void doubly(Node head){
        Node ptr=head,forw=head.next;
        while(ptr!=null){
            Node new_n = new Node(ptr.val);
            forw=ptr.next;
            ptr.next=new_n;
            new_n.next=forw;
            ptr=forw;
        }
    }
    public Node singly(Node head){
        Node ptr=head,forw=head.next,temp;
        head=head.next;
        
        while(forw!=null){
            
            ptr.next=forw.next;
            if(forw.next!=null)
                forw.next=forw.next.next;
            else
                forw.next=null;
            ptr=ptr.next;
            forw=forw.next;

        }
        return head;
    }
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        doubly(head);
        Node ran=null,ptr=head;
        while(ptr!=null){
            if(ptr.random==null){
                ptr.next.random=null;
            }
            else{
                ptr.next.random=ptr.random.next;
            }
            ptr=ptr.next.next;
        }

        return singly(head);
    }
}