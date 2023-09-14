"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        d={}
        ptr=head
        head2=None

        while(ptr!=None):
            temp = Node (ptr.val)
            d[ptr]=temp
            if head2==None:
                head2=temp
            else:
                ptr2=head2
                while ptr2.next!=None:
                    ptr2=ptr2.next
                ptr2.next=temp
            ptr=ptr.next
        ptr=head
        ptr2=head2
        while ptr!=None:
            if(ptr.random==None):
                ptr2.random=None
            else:
                ptr2.random=d[ptr.random]
            ptr=ptr.next
            ptr2=ptr2.next
        return head2

        
        