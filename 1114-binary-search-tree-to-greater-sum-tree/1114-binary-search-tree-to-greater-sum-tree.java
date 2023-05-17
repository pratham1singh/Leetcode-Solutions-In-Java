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

     int s=0;
    public int sum(TreeNode root){
        if(root==null)
            return 0;
        else
            return root.val+sum(root.left)+sum(root.right);
    }
    public void inorder_trans(TreeNode root){
        if(root!=null){
            inorder_trans(root.left);
            // System.out.println(root.val+" "+s);
            int x=root.val;
            root.val=s;
            s-=x;
            inorder_trans(root.right);
        }
    }
    public TreeNode bstToGst(TreeNode root) {
            s=sum(root);
            inorder_trans(root);
            return root;
    }
}
