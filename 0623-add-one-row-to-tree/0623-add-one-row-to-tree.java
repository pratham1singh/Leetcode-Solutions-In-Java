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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode x= new TreeNode(val);
            x.left=root;
            return x;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int l=2,d=1;
        while(l>1&&d!=depth-1){
            TreeNode x=queue.remove();
            l-=1;
            while(x!=null){
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
            queue.add(null);
            l+=1;
            d+=1;

        }
        System.out.println(d+" "+l);
        while(l>1){
            TreeNode x=queue.remove();
            l-=1;
            if(x==null)
                break;
            TreeNode lt=x.left;
            TreeNode rt=x.right,temp;
            
                 temp = new TreeNode(val);
                x.left=temp;
                temp.left=lt;
            
            
                 temp = new TreeNode(val);
                x.right=temp;
                temp.right=rt;
            
        }
        return root;
    }
}