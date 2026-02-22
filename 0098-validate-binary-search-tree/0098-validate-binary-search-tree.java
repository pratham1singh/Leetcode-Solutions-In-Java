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
    public int max(TreeNode node) {
        if(node == null) return Integer.MIN_VALUE;
        return Math.max(node.val, Math.max(max(node.left), max(node.right)));
    }
    public int min(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;
        return Math.min(node.val, Math.min(min(node.left), min(node.right)));
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left!=null && max(root.left) >= root.val) return false;
        if(root.right!=null && min(root.right) <= root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
}