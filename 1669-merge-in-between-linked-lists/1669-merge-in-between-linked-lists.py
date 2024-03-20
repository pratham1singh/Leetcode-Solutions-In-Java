# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeInBetween(self, list1, a, b, list2):
        node1=None
        node2=None
        endnode=None
        ptr=list1
        k=0
        while ptr!=None:
            if k==a-1:
                node1=ptr
            if k==b:
                node2=ptr.next
                break
            k+=1
            ptr=ptr.next
        ptr=list2
        while ptr.next!=None:
            ptr=ptr.next
        endnode=ptr
        node1.next=list2
        endnode.next=node2
        return list1

        

