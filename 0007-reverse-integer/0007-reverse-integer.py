class Solution(object):
    def reverse(self, x):
        if x>0:
            ans=int("".join(list(str(x))[::-1]))
            if ans>(2**31-1):
                return 0
            return ans
        else:
            x=x*-1
            ans=-1*int("".join(list(str(x))[::-1]))
            if ans<((-2)**31):
                return 0
            return ans