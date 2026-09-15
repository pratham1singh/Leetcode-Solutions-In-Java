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
        int height;
        boolean isPerfect;

        public Node(int count, int height, boolean isPerfect) {
            this.count=count;
            this.height=height;
            this.isPerfect=isPerfect;
        }

         public Node() {
            this.count=0;
            this.height = 0;
            this.isPerfect=false;
        }
    }

    public Node find(TreeNode root, int k, List<Integer> arr) {
        if(root == null) return new Node();
        if(root.left==null && root.right==null) {
            arr.add(1);
            return new Node(1, 1, true);
        }

        Node left = find(root.left, k, arr);
        Node right = find(root.right, k, arr);

        Node ans = new Node(
            left.count + right.count + 1,
            Math.max(left.height, right.height) + 1,
            left.isPerfect && right.isPerfect && left.height == right.height
        );

        if(ans.isPerfect) {
            arr.add(ans.count);
        }

        return ans;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();

        find(root, k, ans);

        if(ans.size() < k) return -1;

        Collections.sort(ans, Collections.reverseOrder());

        return ans.get(k-1);
    }
}