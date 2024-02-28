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
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int height(TreeNode root){
        if(root==null)
            return 0;
        else{
            int l=height(root.left);
            int r=height(root.right);
            map.put(root,Math.max(l,r)+1);
            return Math.max(l,r)+1;
        }
    }
    public TreeNode find(TreeNode root){
        if(root==null)
            return null;
        else if(root.left==null&&root.right==null)
            return root;
        else if(map.get(root.left)<map.get(root.right))
            return find(root.right);
        else 
            return find(root.left);
        
    }
    public int findBottomLeftValue(TreeNode root) {
        map.put(root,height(root));
        map.put(null,0);
        return find(root).val;
    }
}