# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def insertIntoMaxTree(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        arr=[]
        def inorder(root):
            nonlocal arr
            if root!=None:
                
                inorder(root.left)
                arr.append(root.val)
                inorder(root.right)
        inorder(root)
        arr.append(val)
        def max2(i,f,list1):
            ind=i
            mx=list1[i]
            for k in range(i,f+1):
                if mx<list1[k]:
                    mx=list1[k]
                    ind=k
            return ind

        def bt(i,f,list2):
            if i<=f:
                ind=max2(i,f,list2)
                new=TreeNode(list2[ind])
                new.left=bt(i,ind-1,list2)
                new.right=bt(ind+1,f,list2)
                return new
        return bt(0,len(arr)-1,arr)
        