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

    int ans=0;
    public int  find(TreeNode root){
        if(root!=null){
            int l=find(root.left);
            int r=find(root.right);
            ans+=Math.abs(l)+Math.abs(r);
            return root.val+l+r-1;

        }
        return 0;

    }
    public int distributeCoins(TreeNode root) {
        find(root);
        return ans;
    }
}