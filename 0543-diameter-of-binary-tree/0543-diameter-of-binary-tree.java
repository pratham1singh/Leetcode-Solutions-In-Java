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
    public int find(TreeNode root){
        if(root==null)
            return 0;
        else{
            return Math.max(map.get(root.left)+map.get(root.right),Math.max(find(root.left),find(root.right)));
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        map.put(root,height(root));
        // System.out.println(map);
        map.put(null,0);
        return find(root);
    }
}