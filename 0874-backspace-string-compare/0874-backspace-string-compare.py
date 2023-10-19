class Solution(object):
    def backspaceCompare(self, s, t):
        list1=[]
        list2=[]
        k=-1
        for i in s:
            if k>=0 and i=="#":
                list1.pop(k)
                k-=1
            elif i=='#' and k<0:
                continue
            else:
                list1.append(i)
                k+=1
        k=-1
        for i in t:
            if k>=0 and i=="#":
                list2.pop(k)
                k-=1
            elif i=='#' and k<0:
                continue

            else:
                list2.append(i)
                k+=1
        return list1==list2