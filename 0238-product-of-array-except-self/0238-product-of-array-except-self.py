class Solution(object):
    def productExceptSelf(self, nums):
        pro=1
        pro1=0
        flag=0
        for i in nums:
            pro*=i
            if i==0:
                flag+=1
        if flag==1:
            pro1=1
            for i in nums:
                if i!=0:
                    pro1*=i
        
        ans=[]
        for j in nums:
            if j!=0:
                ans.append(pro//j)
            else:
                ans.append(pro1)
        return ans
        