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
    public int find(TreeNode root){
        if(root==null)
            return 0;
        else if(root.left==null&&root.right==null)
            return root.val==1?1:0;
        else{
            int l=find(root.left);
            int r=find(root.right);
            if(l==0)
                root.left=null;
            if(r==0)
                root.right=null;
            return l+r+root.val>0?1:0;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        int ans=find(root);
        return ans==0?null:root;
    }
}