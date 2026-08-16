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

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return null;

        if(root.val == p) return root;
        if(root.val == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null) return root;
        else return left!=null ? left : right;
    }

    private int findPathToS(TreeNode root, int s) {
        if(root == null) return 1000000;

        if(root.val == s) return 0;

        return 1 + Math.min(findPathToS(root.left,s), findPathToS(root.right,s));
    }

    private StringBuilder findPathToD(TreeNode root, int d) {
        if(root == null) return null;

        if(root.val == d) return new StringBuilder();

        StringBuilder ans = findPathToD(root.left, d);
        if(ans!=null) {
             ans = ans.insert(0,"L");
        }
        else {
            ans = findPathToD(root.right, d);
            if(ans!=null) {
                ans = ans.insert(0,"R");
            }
        }

        return ans;
    }

    public String getDirections(TreeNode root, int s, int d) {
        TreeNode lca = lowestCommonAncestor(root, s, d);

        int count = findPathToS(lca,s);

        return String.valueOf('U').repeat(count) + findPathToD(lca,d).toString();
    }
}