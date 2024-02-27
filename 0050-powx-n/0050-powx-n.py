class Solution(object):
    def myPow(self, x, n):
        dict1={}
        def find(n):
            if n==0:
                return 1
            elif n==1:
                return x
            elif dict1.get(n)!=None:
                return dict1.get(n)
            elif n%2==0:
                ans=find(n/2)
                dict1[n]=ans*ans
                return ans*ans
            else:
                dict1[n]=x*find(n-1)
                return dict1[n]
        if n>=0:
            return find(n)
        else:
            return 1/find(-n)