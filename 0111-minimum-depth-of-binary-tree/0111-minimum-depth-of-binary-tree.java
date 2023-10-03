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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
       
        queue.add(root);
        queue.add(null);
        int l=2,level=1;

        while(l>1){
            
            TreeNode x=queue.poll();
            l-=1;
           
           
            while(x!=null){
                if(x.left==null&&x.right==null){
                
                return level;
            }
                if(x.left!=null){
                    queue.add(x.left);
                    l+=1;
                }
                if(x.right!=null){
                    queue.add(x.right);
                    l+=1;
                }
                x=queue.poll();
                l-=1;
            }
            queue.add(null);
            l+=1;
            level+=1;
        }
        return -1;
    }
}