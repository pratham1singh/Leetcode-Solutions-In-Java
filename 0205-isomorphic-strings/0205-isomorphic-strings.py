class Solution(object):
    def isIsomorphic(self, s, t):
        dict1={}
        dict2={}
        l=len(s)
        for i in range(l):
            if s[i] in dict1:
                if dict1[s[i]]!=t[i]:
                    return False
            
            else:
                if t[i] in dict2:
                    return False
                dict1[s[i]]=t[i]
                if t[i] not in dict2:
                    dict2[t[i]]=1
                
        return True