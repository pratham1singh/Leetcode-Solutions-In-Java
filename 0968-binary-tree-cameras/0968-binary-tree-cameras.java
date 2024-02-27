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
    public int find(TreeNode root){
        if(root==null)
            return 0;
        else if(root.left==null&&root.right==null)
            return -1;
        else{
            int l=find(root.left);
            int r=find(root.right);
            
            if(l==-1||r==-1){
                ans+=1;
                return 1;
            }
           
            else if(l==1||r==1){
                return 0;
            }
            
            else
                return -1;
            
            
            
            
        }
    }
    public int minCameraCover(TreeNode root) {
       
        int c=find(root);
        
        if(c==-1)
            return ans+1;
        return ans;
    }
}