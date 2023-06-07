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
    HashMap<TreeNode,TreeNode>map =new HashMap<>();
    int ans=0;
    public void dfs(TreeNode root){
        if(root!=null){
           if(root.left!=null)
                map.put(root.left,root);
            if(root.right!=null)
                map.put(root.right,root);
            dfs(root.left);
            dfs(root.right);
        }
    }
    public void find(TreeNode root){
        if(root!=null){
            
            if(map.get(root)!=null&&map.get(map.get(root))!=null&&map.get(map.get(root)).val%2==0)
                ans+=root.val;
            find(root.left);
            find(root.right);
                
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        map.put(root,null);
        find(root);
        return ans;

    }
}