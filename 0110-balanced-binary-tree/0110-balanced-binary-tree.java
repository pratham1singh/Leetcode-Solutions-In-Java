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
    class Pair{
        int height;
        boolean isBalanced;

        Pair(int a, boolean b) {
            isBalanced = b;
            height = a;
        }
    }

    public Pair find(TreeNode root) {
        if(root == null) return new Pair(0, true);
        Pair l = find(root.left);
        Pair r = find(root.right);
        return new Pair(Math.max(l.height,r.height) + 1, (Math.abs(l.height-r.height) <=1) && l.isBalanced && r.isBalanced);
    }
    public boolean isBalanced(TreeNode root) {
        Pair ans = find(root);
        return ans.isBalanced;
    }
}