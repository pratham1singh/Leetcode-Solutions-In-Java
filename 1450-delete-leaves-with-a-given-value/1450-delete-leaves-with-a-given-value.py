# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        n=0
        def count(root,key):
            nonlocal n
            if root!=None:
                if root.val==key:
                    n+=1
                count(root.left,key)
                count(root.right,key)
        count(root,target)
        print(n)
        def delete(root,key):
            if root==None:
                return None
            if root.val==key and  root.left==None and root.right==None:
                    return None
            root.left=delete(root.left,key)
            root.right= delete(root.right,key)
            return root
            
        for i in range(n):
            root=delete(root,target)
        return root