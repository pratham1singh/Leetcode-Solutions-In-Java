class Solution(object):
    def firstMissingPositive(self, nums):
        dict1={}
        for i in nums:
            dict1[i]=1
        l=len(nums)
        for i in range(1,l+1):
            if i not in dict1:
                return i
        return l+1
        