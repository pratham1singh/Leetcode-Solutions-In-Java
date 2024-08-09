/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorder[],inorder[],n,i=0;

    public int findIndex(int x){
        int ind=-1;
        for(int i=0;i<n;i++)
            if(inorder[i]==x)
                return i;
        return -1;
    }

    public TreeNode find(int j, int k){
        if(k-j+1<=0||i>=n)  return null;
        int ind=findIndex(preorder[i]);
        TreeNode root = new TreeNode(preorder[i++]);
        root.left=find(j,ind-1);
        root.right=find(ind+1,k);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        n=inorder.length;
        return find(0,n-1);
    }
}