# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def pairSum(self, head):
        n=0
        ptr=head
        while ptr!=None:
            n+=1
            ptr=ptr.next
        ptr=head
        c=0
        list1=[]
        while ptr!=None:
            if c>=(n//2):
                list1.append(ptr.val)
            c+=1
            ptr=ptr.next
        ptr=head
        c=0
        mx=0
        while c<=(n//2)-1 :
            if mx<(ptr.val+list1[-1]):
                mx=ptr.val+list1[-1]
            list1.pop()
            ptr=ptr.next
            c+=1
        return mx
            