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


    int sum1=0,ans=0,n=0;
    public void sum(TreeNode root){
        if(root!=null){
            n+=1;
            sum1+=root.val;
            sum(root.left);
            sum(root.right);
        }
        else
            return;

    }

    
    public void solve(TreeNode root){
        if(root!=null){
            n=0;sum1=0;
            sum(root);
            if(root.val==(int)(sum1/n))
                ans+=1;
            solve(root.left);
            solve(root.right);
            
        }
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
}



