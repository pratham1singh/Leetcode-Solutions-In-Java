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
    TreeNode subtree=null;
    public boolean check(TreeNode root,TreeNode key){
        if(root==null)
            return false;
        else if(root==key)
            return true;
        else{
            return check(root.left,key)|| check(root.right,key);
        }
    }
    public void find(TreeNode root,ArrayList<TreeNode> arr){
        if(root!=null){
            boolean ans=true;
            for(TreeNode x:arr){
                ans=ans&&check(root,x);
                if(ans==false)
                    break;
            }
            if(ans){
                
                subtree=root;
                find(root.left,arr);
                find(root.right,arr);
            }
            
        }
        
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        else{
            return 1+Math.max(depth(root.left),depth(root.right));
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        int n=2,d=depth(root);
        queue.add(root);
        queue.add(null);
        int i=1;
        while(n>1&&i!=d){
            TreeNode x=queue.remove();
            n-=1;
            
            while(x!=null){
                if(x.left!=null){
                    queue.add(x.left);
                    n+=1;
                }
                if(x.right!=null){
                    queue.add(x.right);
                    n+=1;
                }
                x=queue.remove();
                n-=1;
            }
            queue.add(null);
            n+=1;
            i+=1;
            
        }
        ArrayList<TreeNode> arr=new  ArrayList<TreeNode>();
        while(n>1){
            arr.add(queue.remove());
            n-=1;
        }
        find(root,arr);
        return subtree;
    }
}