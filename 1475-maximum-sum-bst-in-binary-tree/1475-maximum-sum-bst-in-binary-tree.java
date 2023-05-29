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
    int max_sum=0;
    HashMap<TreeNode,Boolean> map=new HashMap<TreeNode,Boolean>();
    HashMap<TreeNode,Integer> smap=new HashMap<TreeNode,Integer>();
    public int sum(TreeNode root){
        if(root==null)
            return 0;
        else if(smap.get(root)!=null)
            return smap.get(root);
        else
            return root.val+sum(root.right)+sum(root.left);
    }
    public int max(TreeNode root){
        if(root==null)
            return -1;
        TreeNode ptr=root;
        while(ptr.right!=null){
            ptr=ptr.right;
        }
        return ptr.val;
    }
    public int min(TreeNode root){
        if(root==null)
            return -1;
        TreeNode ptr=root;
        while(ptr.left!=null){
            ptr=ptr.left;
        }
        return ptr.val;
    }
    public boolean isbst(TreeNode root){
            if(root==null)
                return true;
            else if(root.left==null&&root.right==null)
                return true;
            else{
                boolean l=map.get(root.left),r=map.get(root.right);
               
            
             if(l&&r&&(root.left==null||max(root.left)<root.val)&&(root.right==null||min(root.right)>root.val))
                return true;
             else
                return false;
             }
      
    }
    public void find(TreeNode root){
            if(root!=null){
                 find(root.left);
                 find(root.right);
                if(isbst(root)){
                    map.put(root,true);
                    int s=sum(root);
                    smap.put(root,s);
                    if(max_sum<s)
                        max_sum=s;
                    System.out.println(s);
                }
                else
                    map.put(root,false);
                
            }
    }
    public int maxSumBST(TreeNode root) {
        map.put(null,true);
        find(root);

        return max_sum;
    }
}