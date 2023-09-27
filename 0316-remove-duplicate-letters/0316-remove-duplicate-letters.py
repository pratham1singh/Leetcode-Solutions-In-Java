class Solution(object):
    def removeDuplicateLetters(self, s):
        ind_max={}
        stack=[]
        selected={}
        i=0
        n=len(s)
        for i in range(n):
            if ind_max.get(s[i])!=None:
                ind_max[s[i]]=max(ind_max[s[i]],i)
            else:
                ind_max[s[i]]=i
        
        i=0
        l=0
        while i<n:
            if selected.get(s[i])!=None:
                i+=1
                continue
            elif l>0:
                if stack[-1]<s[i]:
                    selected[s[i]]=1
                    stack.append(s[i])
                    l+=1
                    i+=1
                else:
                    while l>0 and stack[-1]>s[i] and ind_max[stack[-1]]>i:
                        del selected[stack[-1]]
                        stack.pop(-1)
                        l-=1
                    selected[s[i]]=1
                    stack.append(s[i])
                    l+=1
                    i+=1
            else:
                selected[s[i]]=1
                stack.append(s[i])
                l+=1
                i+=1
        return "".join(stack)
                    


        