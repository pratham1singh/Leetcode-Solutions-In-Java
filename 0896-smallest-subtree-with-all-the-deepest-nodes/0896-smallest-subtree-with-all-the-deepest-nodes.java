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
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(depth(root.left),depth(root.right));
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int l=depth(root.left);
        int r=depth(root.right);
        if(l==r)
            return root;
        else if(l>r)
            return subtreeWithAllDeepest(root.left);
        else
             return subtreeWithAllDeepest(root.right);
    }
}