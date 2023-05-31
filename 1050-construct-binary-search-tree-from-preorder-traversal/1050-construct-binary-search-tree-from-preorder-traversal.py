# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        st=0
        l=len(preorder)

        def bt(i,f,pre,inorder):
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
        return bt(0,l-1,preorder,sorted(preorder))