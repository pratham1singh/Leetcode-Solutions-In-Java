# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        if head.next==None:
            return
        head2=None
        slow=fast=head
        pre=None
        while fast!=None and fast.next!=None:
            pre=slow
            slow=slow.next
            fast=fast.next.next
        head2=slow
        pre.next=None
        pre=None
        cr=head2
        forw=None
        while cr!=None:
            forw=cr.next
            cr.next=pre
            pre=cr
            cr=forw
        head2=pre
        ptr=head
        while ptr!=None:
            node=head2
            head2=head2.next
            forw=ptr.next
            ptr.next=node
            node.next=forw
            pre=node
            ptr=forw
        if head2!=None:
            pre.next=head2





