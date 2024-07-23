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
    int target;
    public int find(TreeNode root,int s){
         
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return s==target?1:0;
        int a=0,b=0;
        if(root.left!=null)
            a=find(root.left,s+root.left.val);
        if(root.right!=null)
            b=find(root.right,s+root.right.val);
        if(s==target)
            return 1+a+b;
        else
            return a+b;
    }
    public int traverse(TreeNode root){
        if(root==null)
            return 0;
        else
            return find(root,root.val)+traverse(root.left)+traverse(root.right);
    }
    public int pathSum(TreeNode root, int targetSum) {
        target=targetSum;
        return traverse(root);
    }
}