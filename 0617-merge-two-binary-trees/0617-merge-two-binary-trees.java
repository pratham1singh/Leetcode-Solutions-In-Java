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
    public TreeNode make(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return null;
        else if(root1==null&&root2!=null){
            TreeNode x= new TreeNode(root2.val);
            x.left=make(root1,root2.left);
            x.right=make(root1,root2.right);
            return x;
        }
        else if(root1!=null&&root2==null){
            TreeNode x= new TreeNode(root1.val);
            x.left=make(root1.left,root2);
            x.right=make(root1.right,root2);
            return x;
        }
        else{
            TreeNode x = new TreeNode(root1.val+root2.val);
            x.left=make(root1.left,root2.left);
            x.right=make(root1.right,root2.right);
            return x;
        }
        
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return make(root1,root2);
    }
}