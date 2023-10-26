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
    HashMap<TreeNode,Integer> visited= new HashMap<>();
    HashMap<TreeNode,Integer> calculated= new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        
        else if(visited.get(root)!=null){
            return rob(root.left)+rob(root.right);
        }
        else if(calculated.get(root)!=null)
            return calculated.get(root);
        else if(root.left==null&&root.right==null)
            return root.val;
        else{
            int without=rob(root.left)+rob(root.right);
            visited.put(root.left,1);
            visited.put(root.right,1);
            int with = root.val+rob(root.left)+rob(root.right);
            visited.remove(root.left);
            visited.remove(root.right);
            calculated.put(root,Math.max(without,with));
            return Math.max(without,with);
        }
    }
}