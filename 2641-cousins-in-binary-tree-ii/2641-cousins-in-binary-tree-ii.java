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
    private int height(TreeNode root) {
        if(root==null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private void findLevelSum(TreeNode root, int level, int[] sum, HashMap<TreeNode, TreeNode> parent) {
        if(root==null) return;
        sum[level] += root.val;

        root.val = 0;
        if(root.left!=null) {
            root.val+=root.left.val;
            parent.put(root.left, root);
        }
        if(root.right!=null) {
            root.val+=root.right.val;
            parent.put(root.right, root);
        }

        findLevelSum(root.left, level+1, sum, parent);
        findLevelSum(root.right, level+1, sum, parent);
    }



    private void replace(TreeNode root, int level, int[] sum, HashMap<TreeNode, TreeNode> parent) {
        if(root==null) return;

        replace(root.left, level+1, sum, parent);
        replace(root.right, level+1, sum, parent);

        root.val = sum[level] - parent.get(root).val;
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, new TreeNode(root.val));

        int n = height(root);

        int[] sum = new int[n];

        findLevelSum(root, 0, sum, parent);
        replace(root, 0, sum, parent);

        return root;
    }
}