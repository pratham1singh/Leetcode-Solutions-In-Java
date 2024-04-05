class Solution(object):
    def makeGood(self, s):
        list1=[s[0]]
        k=0
        for i in s[1:]:
            if not list1==[]:
                if ((i.islower() and list1[k].isupper() ) and(i==list1[k].lower()))  or ((i.isupper() and list1[k].islower()) and (i==list1[k].upper())):
                    list1.pop()
                    k-=1
                    continue
                   
            list1.append(i)
            k+=1

            
        return "".join(list1)
        
        
            
