class Solution(object):
    def convert(self, s, r):
        if r==1:
            return s
        list1=[[] for i in range(r)]
        c=0
        w=1
        ans=""
        for i in s:

            list1[c].append(i)
            if w==1:
                c+=1
            else:
                c-=1
            if c==r:
                w=w*-1
                c=r-2
            elif c==-1:
                w=w*-1
                c=c+2
        for i in list1:
            ans+="".join(i)
        return ans