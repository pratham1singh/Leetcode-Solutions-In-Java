class Solution(object):
    def lengthOfLongestSubstring(self, s):
        i=j=0
        k=1
        l=len(s)
        if l==0:
            return 0
        l1=1
        dict1={s[0]:0}
        while k<l:
            if s[k] not in dict1:
                j+=1
                dict1[s[k]]=k
                k+=1
            else:
                if l1<j-i+1:
                    l1=j-i+1
                co=dict1[s[k]]
                while i!=co:
                    del dict1[s[i]]
                    i+=1
                i+=1
                
                # i=dict1[s[k]]+1
                j+=1
                dict1[s[k]]=k
                k+=1
        if l1<j-i+1:
            l1=j-i+1
        return l1


        
        