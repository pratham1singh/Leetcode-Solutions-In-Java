class Solution(object):
    def compareVersion(self, version1, version2):
        list1=list(map(int,version1.split('.')))
        list2=list(map(int,version2.split('.')))

        while len(list1)>0 and list1[-1]==0:
            list1.pop()

        while len(list2)>0 and list2[-1]==0:
            list2.pop()
       
        i=0
        j=0
        n1=len(list1)
        n2=len(list2)

        while i<n1 and j<n2:
            if list1[i]>list2[i]:
                return 1
            elif list2[i]>list1[i]:
                return -1
            else:
                i+=1
                j+=1
                
        if i==n1 and j==n2:
            return 0
        elif i==n1:
            return -1
        return 1
        