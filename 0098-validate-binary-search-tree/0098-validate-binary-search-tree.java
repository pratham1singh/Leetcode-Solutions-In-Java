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
   public ArrayList<Integer> inOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<Integer> left = inOrder(root.left);
    List<Integer> right = inOrder(root.right);

    ArrayList<Integer> ans = new ArrayList<>();
    ans.addAll(left);
    ans.add(root.val);
    ans.addAll(right);
    return ans;
   }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = inOrder(root);
        
        for(int i=1;i<arr.size(); i++) {
            if(arr.get(i) <= arr.get(i-1)) return false;
        }

        return true;
    }
}