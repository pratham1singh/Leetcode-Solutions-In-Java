class Solution(object):
    def reverseString(self, s):
        i=0
        f=len(s)-1
        while i<=f:
            s[i],s[f]=s[f],s[i]
            i+=1
            f-=1
        