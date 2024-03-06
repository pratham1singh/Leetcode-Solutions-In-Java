# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        dict1={}
        ptr=head
        if ptr==None:
            return False
        while ptr!=None:
            if ptr in dict1:
                return True
            else:
                dict1[ptr]=1
                ptr=ptr.next
        return False