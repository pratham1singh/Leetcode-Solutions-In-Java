class Solution(object):
    def searchRange(self, nums, target):
        i=0
        l=len(nums)
        f=l-1
        m=(i+f)//2
        p=-1
        while i<=f:
            if nums[m]==target:
                p=m
                break
            elif nums[m]<target:
                i=m+1
            else:
                f=m-1
            m=(i+f)//2
        if p==-1:
            return [-1,-1]
        i=f=p
        while i>=0 and nums[i]==target:
            i-=1
        while f<l and nums[f]==target:
            f+=1

        return [i+1,f-1]

                

        