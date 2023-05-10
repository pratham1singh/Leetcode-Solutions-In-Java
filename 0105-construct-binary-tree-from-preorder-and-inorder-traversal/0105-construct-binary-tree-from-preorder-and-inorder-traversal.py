# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        st=0
        l=len(inorder)
        def bt(i,f,pre,indorder):
            nonlocal st,l
            if i<=f and st<l:
                ind=inorder.index(pre[st])
                new=TreeNode(inorder[ind])
                st+=1
                new.left=bt(i,ind-1,pre,inorder)
                new.right=bt(ind+1,f,pre,inorder)
                return new
            else:
                return None
        return bt(0,len(preorder)-1,preorder, inorder)
