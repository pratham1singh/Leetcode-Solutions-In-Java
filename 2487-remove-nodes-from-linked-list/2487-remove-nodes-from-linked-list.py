# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNodes(self, head):
        ptr=head
        list1=[]
        list2=[]
        st=[]
        while ptr!=None:
            list1.append(ptr.val)
            ptr=ptr.next
        l1=len(list1)
        l2=0
        i=l1-1
        while i>=0:
            if l2==0:
                list2.append(-1)
                st.append(list1[i])
                i-=1
                l2+=1
            else:
                if st[-1]>list1[i]:
                    list2.append(st[-1])
                    st.append(list1[i])
                    l2+=1
                else:
                    while l2>0 and st[-1]<=list1[i]:
                        st.pop(-1)
                        l2-=1
                    if l2==0:
                        list2.append(-1)
                    else:
                        list2.append(st[-1])
                    st.append(list1[i])
                    l2+=1
                i-=1
        list2=list2[::-1]
        print(list2)
        del list1
        del st
        ptr=head
        pre=head
        i=0
        while ptr!=None:
            
            if list2[i]!=-1:
                pre.next=ptr.next
                ptr=ptr.next
            else:
                pre=ptr
                ptr=ptr.next
            i+=1
        if list2[0]!=-1:
            head=head.next
        return head

