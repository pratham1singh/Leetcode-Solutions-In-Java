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
    public TreeNode find(TreeNode root1,TreeNode root2,int key){
        if(root1==null)
            return null;
        else if(root1.val==key)
            return root2;
        else{
           TreeNode x= find(root1.left,root2.left,key);
           if(x!=null)
            return x;
            return find(root1.right,root2.right,key);
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(original,cloned,target.val);
    }
}