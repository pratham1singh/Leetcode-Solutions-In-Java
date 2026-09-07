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
    private class Node {
        int count;
        int max;

        public Node() {
            this.count = 0;
            this.max= Integer.MIN_VALUE;
        }

         public Node(int count, int max) {
            this.count = count;
            this.max= max;
        }
    }

    public Node count(TreeNode root) {
        if(root == null) return new Node();

        Node left = count(root.left);
        Node right = count(root.right);

        return new Node(left.max<=root.val && right.max<=root.val ? left.count+right.count+1 : left.count+right.count,
        Math.max(root.val, Math.max(left.max, right.max))
        );
    }
    public int countDominantNodes(TreeNode root) {
        Node ans  = count(root);

        return ans.count;
    }
}