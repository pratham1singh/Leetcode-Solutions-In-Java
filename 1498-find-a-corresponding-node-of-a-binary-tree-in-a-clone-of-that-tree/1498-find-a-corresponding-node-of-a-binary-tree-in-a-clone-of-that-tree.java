/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode find(TreeNode root,int key){
        if(root==null)
            return null;
        else if(root.val==key)
            return root;
        else{
            TreeNode x=find(root.left,key);
            if(x!=null)
                return x;
            x=find(root.right,key);
            return x;
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(cloned,target.val);
    }
}