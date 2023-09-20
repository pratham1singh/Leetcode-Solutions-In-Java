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
    List <String> ans = new ArrayList<>();
    public void find(TreeNode root,String str1){
        
        if(root.left==null&&root.right==null){
            ans.add(str1+root.val);
            return;
        }
        else{
            if(root.left!=null){
                find(root.left,str1+root.val+"->");
            }
            if(root.right!=null){
                find(root.right,str1+root.val+"->");
            }

        }

    }
    public List<String> binaryTreePaths(TreeNode root) {
        find(root,"");
        return ans;
    }
}