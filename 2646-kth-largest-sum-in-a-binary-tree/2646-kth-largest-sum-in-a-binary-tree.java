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
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList <Long> list1 = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int l=2;
        queue.add(root);
        queue.add(null);
        while(l>1){
            TreeNode x = queue.remove();
            l-=1;
            long s=0;
            while(x!=null){
                s+=x.val;
                if(x.left!=null){
                    queue.add(x.left);
                    l+=1;
                }
                if(x.right!=null){
                    queue.add(x.right);
                    l+=1;
                }
                x=queue.remove();
                l-=1;
            }
            list1.add(s);
            queue.add(null);
            l+=1;
        }
        if(list1.size()<k){
            return -1;
        }
        Collections.sort(list1);
        return list1.get(list1.size()-k);
    }
}