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
    public TreeNode find(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return null;
        else if(root1==null&&root2!=null)
            return root2;
        else if(root1!=null&&root2==null)
            return root1;
        else{
            TreeNode x= new TreeNode(root1.val+root2.val);
            x.left=find(root1.left,root2.left);
            x.right=find(root1.right,root2.right);
            return x;
        }
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return find(root1,root2);
    }
}