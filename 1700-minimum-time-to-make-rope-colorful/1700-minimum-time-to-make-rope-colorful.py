class Solution(object):
    def minCost(self, colors, neededTime):
        l=len(colors)
        x=0
        ans=0
        i=0
        f=1
        while f<=l-1:
             if colors[i]==colors[f]:
                 if neededTime[i]<neededTime[f]:
                     ans+=neededTime[i]
                     i=f
                     f+=1
                 else :
                    ans+=neededTime[f]
                    f+=1
             else:
                i=f
                f+=1
        return ans


