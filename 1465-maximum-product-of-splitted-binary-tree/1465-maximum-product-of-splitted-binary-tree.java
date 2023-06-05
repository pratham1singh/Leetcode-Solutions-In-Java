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
    int sum=0;
    double ans=0;
    public void sum2(TreeNode root){
        if(root!=null){
            sum+=root.val;
            sum2(root.left);
            sum2(root.right);
        }

    }
    public double find(TreeNode root){
        if(root!=null){
            double l=find(root.left);
            double r=find(root.right);
            double s=l+r+root.val;
            if(ans<(sum-s)*s)
                ans=(sum-s)*s;
            return s;
        }
        return 0;
    }
    public int maxProduct(TreeNode root) {
        sum2(root);
        find(root);
        return (int)(ans%(Math.pow(10,9)+7));
    }
}