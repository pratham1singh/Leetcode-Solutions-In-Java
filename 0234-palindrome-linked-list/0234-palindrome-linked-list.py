# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        ptr=head
        str1=""
        while ptr!=None:
            str1+=str(ptr.val)
            ptr=ptr.next
        i=0
        f=len(str1)-1
        while i<=f:
            if str1[i]==str1[f]:
                i+=1
                f-=1
            else:
                return False
        return True