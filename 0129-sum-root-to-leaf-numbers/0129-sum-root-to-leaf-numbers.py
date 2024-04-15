# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans=[]
        str1=""
        def do(root):
            nonlocal ans,str1
            if root!=None:
            
                str1+=str(root.val)
                if root.left==None and root.right==None:
                    ans.append(int(str1))
                    # str1=str1[:-1]
                else:
                    if root.left:
                        do(root.left)
                        str1=str1[:-1]
                    if root.right:
                        do(root.right)
                        str1=str1[:-1]
        do(root)
        return sum(ans)

