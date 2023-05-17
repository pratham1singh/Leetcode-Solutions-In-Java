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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int n=2,sum=0;
        while(n>1){
            sum=0;
            while(1>0){

                TreeNode x=queue.remove();
                if(x==null)
                    break;
                sum+=x.val;
                n-=1;
                if(x.left!=null){
                    queue.add(x.left);
                    n+=1;
                }
                if(x.right!=null){
                    queue.add(x.right);
                    n+=1;
                }

            }
            if(n==1){
                return sum;
            }
            
            queue.add(null);
        
        }
        return 0;
    }
}