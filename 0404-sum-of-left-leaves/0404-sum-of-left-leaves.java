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
    public int find(TreeNode root,int flag){
        if(root==null)
            return 0;
        else if(root.left==null&&root.right==null&&flag==-1)
            return root.val;
        else
            return find(root.left,-1)+find(root.right,1);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return find(root,1);
    }
}