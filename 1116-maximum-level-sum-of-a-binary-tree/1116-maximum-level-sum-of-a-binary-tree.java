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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int l=2 ,mx=root.val,ml=1,level=1;

        while(l>1){
            TreeNode x=queue.remove();
            l-=1;
            int c=0;
            while(x!=null){
                c+=x.val;
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
            if(mx<c){
                mx=c;
                ml=level;
            }
            level+=1;
            queue.add(null);
            l+=1;

        }
        return ml;

    }
}