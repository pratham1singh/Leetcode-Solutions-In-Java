class Solution(object):
    def isSameTree(self, p, q):
        if p==q==None:
            return True
        list1=[p]
        list2=[q]
        l1=l2=1
        while l1!=0:
            if (list1[0]==None and list2[0]!=None) or (list1[0]!=None and list2[0]==None):
                return False
                
            elif list1[0]!=None and list1[0].val!=list2[0].val:
                return False
            
            if list1[0]!=None:
                list1.append(list1[0].left)
                l1+=1
                list1.append(list1[0].right)
                l1+=1
            if list2[0]!=None:
                list2.append(list2[0].left)
                l2+=1
                list2.append(list2[0].right)
                l2+=1
            
            
            
            list1.pop(0)
            list2.pop(0)
            l1-=1
            l2-=1
            if l1!=l2:
                return False
        return True
        